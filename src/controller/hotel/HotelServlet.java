package controller.hotel;

import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.xdevapi.JsonArray;
import service.HotelService.HotelService;
import service.HotelService.HotelServiceImpl;
import util.Constants;
import util.Page;
import vo.hotelVo.Hotel;
import vo.hotelVo.Living;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Timgreat
 * @date 2020/12/5 - 14:43
 */
public class HotelServlet extends HttpServlet {
    //sevlet方法复用
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method=req.getParameter("method");
        if(method.equals("savepwd")&&method!=null){
            this.updatePwd(req,resp);
        }else if(method.equals("pwdmodify")&&method!=null){
            this.pwdModify(req, resp);
        }else if(method.equals("query")&&method!=null){
            this.query(req, resp,1,"/jsp/hotelJsp/jsp/userlist.jsp");
        }else if(method.equals("query2")&&method!=null){
            this.query(req, resp,0,"/jsp/hotelJsp/jsp/waitlist.jsp");
        }else if(method.equals("add")&&method!=null){
            this.addLiving(req, resp);
        }else if(method.equals("idExist")&&method!=null){
            this.idExist(req,resp);
        }else if(method.equals("deleteLiving")&&method!=null){
            this.deleteLiving(req,resp);
        }else if(method.equals("modifyLiving")&&method!=null){
            this.modifyLiving(req,resp,"/jsp/user.do?method=query","/jsp/hotelJsp/jsp/usermodify.jsp",1);
        }else if(method.equals("findLiving")&&method!=null){
            this.viewLiving(req,resp,"/jsp/hotelJsp/jsp/usermodify.jsp");
        }else if(method.equals("allocateLiving")&&method!=null){
            this.modifyLiving(req,resp,"/jsp/user.do?method=query2","/jsp/hotelJsp/jsp/waitmodify.jsp",0);
        }else if(method.equals("findLiving2")&&method!=null){
            this.viewLiving(req,resp,"/jsp/hotelJsp/jsp/waitmodify.jsp");
        }else if(method.equals("viewLiving")&&method!=null){
            this.viewLiving(req,resp,"/jsp/hotelJsp/jsp/userview.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    //修改密码
    public void updatePwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute=req.getSession().getAttribute(Constants.HOTEL_SESSION);
        String newpassword=req.getParameter("newpassword");
        System.out.println(newpassword);
        boolean flag=false;
        if(attribute!=null&&newpassword!=null&&!newpassword.equals("")){
            HotelService hotelService=new HotelServiceImpl();
            flag=hotelService.updatePwd(((Hotel)attribute).getHotelId(),newpassword);
            if(flag){
                req.setAttribute(Constants.MESSAGE,"修改密码成功，请退出，使用新密码登录");
                req.getSession().removeAttribute(Constants.HOTEL_SESSION);
                req.getRequestDispatcher("/jsp/hotelJsp/login.jsp").forward(req,resp);
            }
            else{
                req.setAttribute(Constants.MESSAGE,"密码修改失败");
            }
        }else{
            req.setAttribute(Constants.MESSAGE,"新密码错误");
        }
        try{
            req.getRequestDispatcher("/jsp/hotelJsp/jsp/pwdmodify.jsp").forward(req,resp);
        }catch(ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //对旧密码进行验证
    public void pwdModify(HttpServletRequest req, HttpServletResponse resp){
        Object attribute=req.getSession().getAttribute(Constants.HOTEL_SESSION);
        String oldPassword=req.getParameter("oldpassword");
        Map<String,String> resultMap=new HashMap<String,String>();
        if(attribute==null){
            resultMap.put("result","sessionerror");
        }else if(oldPassword==null||oldPassword.equals("")){
            resultMap.put("result","error");
        }else{
            String password=((Hotel)attribute).getPassword();
            if(oldPassword.equals(password)){
                resultMap.put("result","true");
            }else{
                resultMap.put("result","false");
            }
        }
        try{
            resp.setContentType("application/json");
            PrintWriter pw=resp.getWriter();
            pw.write(JSONArray.toJSONString(resultMap));
            pw.flush();
            pw.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    //查询住宿情况
    public void query(HttpServletRequest req, HttpServletResponse resp,int flag,String url){
        String queryName=req.getParameter("queryname");
        String pageIndex=req.getParameter("pageIndex");
        int hotelId=0;
        int numOfRoom=0;
        Object attribute=req.getSession().getAttribute(Constants.HOTEL_SESSION);
        HotelService hotelService=new HotelServiceImpl();
        List<Living> livingList=null;
        int pageSize=8;
        int currentPage=1;

        if(queryName==null){
            queryName="";
        }
        if(attribute!=null){
            hotelId=((Hotel)attribute).getHotelId();
        }
        if(pageIndex!=null){
            currentPage=Integer.parseInt(pageIndex);
        }
        //分页
        int totalCount=hotelService.getLivingCount(queryName,hotelId,flag);
        Page page=new Page();
        page.setCurrentPage(currentPage);
        page.setPageSize(pageSize);
        page.setTotalCount(totalCount);
        int totalPageCount=page.getTotalPageCount();
        if(currentPage<1){
            currentPage=1;
        }else if(currentPage>totalPageCount){
            currentPage=totalPageCount;
        }

        livingList=hotelService.getLivingList(queryName,hotelId,currentPage,pageSize,flag);
        numOfRoom=hotelService.getNumOfRoom(hotelId);
        req.setAttribute("livingList",livingList);
        req.setAttribute("totalCount",totalCount);
        req.setAttribute("currentPage",currentPage);
        req.setAttribute("totalPageCount",totalPageCount);
        req.setAttribute("quaryname",queryName);
        req.setAttribute("numOfRoom",numOfRoom);
        try{
            req.getRequestDispatcher(url).forward(req,resp);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }
    //添加住宿信息
    public void addLiving(HttpServletRequest req, HttpServletResponse resp) {
        String confId=req.getParameter("confId");
        String confereeName=req.getParameter("confName");
        String startTime=req.getParameter("startTime");
        String endTime=req.getParameter("endTime");
        String roomId=req.getParameter("roomId");
        String request=req.getParameter("request");
        String response=req.getParameter("response");
        String sex=req.getParameter("sex");
        Living living=new Living();
        Object attribute=req.getSession().getAttribute(Constants.HOTEL_SESSION);

        living.setConfId(Integer.valueOf(confId));
        living.setConfereeName(confereeName);
        living.setSex(sex);
        living.setRoomId(Integer.valueOf(roomId));
        living.setRequest(request);
        living.setResponse(response);
        if(attribute!=null){
            living.setHotelId(Integer.valueOf(((Hotel)attribute).getHotelId()));
        }else{
            try{
                resp.sendRedirect(req.getContextPath()+"/jsp/hotelJsp/login.jsp");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        try {
            living.setStartTime(new SimpleDateFormat("yyyy-MM-dd").parse(startTime));
            living.setEndTime(new SimpleDateFormat("yyyy-MM-dd").parse(endTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try{
            HotelService hotelService=new HotelServiceImpl();
            if(hotelService.addLiving(living)){
                resp.sendRedirect(req.getContextPath()+"/jsp/user.do?method=query");
            }else{
                req.setAttribute(Constants.MESSAGE,"添加失败，请重新添加");
                req.getRequestDispatcher("/jsp/hotelJsp/jsp/useradd.jsp").forward(req, resp);
            }
        }catch(IOException | ServletException e){
            e.printStackTrace();
        }
    }
    //判断住宿者ID是否存在
    public void idExist(HttpServletRequest req, HttpServletResponse resp) {
        String confId=req.getParameter("confId");
        HashMap<String,String> resultMap=new HashMap<>();
        if(confId==null||confId.equals("")){
            resultMap.put("confId","void");
        }else{
            HotelService hotelService=new HotelServiceImpl();
            if(hotelService.isExist(Integer.valueOf(confId))){
                resultMap.put("confId","exist");
            }else {
                resultMap.put("confId","right");
            }
        }
        try{
            resp.setContentType("application/json");
            PrintWriter pw = resp.getWriter();
            pw.write(JSONArray.toJSONString(resultMap));
            pw.flush();
            pw.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    //删除住宿信息
    public void deleteLiving(HttpServletRequest req, HttpServletResponse resp){
        String confId=req.getParameter("confId");
        String flag=req.getParameter("flag");
        HashMap<String,String> resultMap=new HashMap<>();
        int del=Integer.valueOf(confId);
        int sign=Integer.valueOf(flag);
        System.out.println("sign:"+sign);
        Object attribute=req.getSession().getAttribute(Constants.HOTEL_SESSION);
        HotelService hotelService=new HotelServiceImpl();
        if(attribute!=null){
            int hotelId=((Hotel)attribute).getHotelId();
            System.out.println("hotelId"+hotelId);
            if(hotelService.deleteLiving(del,hotelId,sign)){
                resultMap.put("deleteResult","true");
            }else{
                resultMap.put("deleteResult","false");
            }
        }else{
            resultMap.put("deleteResult","false");
        }
        try{
            resp.setContentType("application/json");
            PrintWriter pw = resp.getWriter();
            pw.write(JSONArray.toJSONString(resultMap));
            pw.flush();
            pw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //根据ID查找住宿记录
    public void viewLiving(HttpServletRequest req, HttpServletResponse resp,String url){
        String confId=req.getParameter("confId");
        System.out.println(confId);
        if(confId!=null&&!confId.equals("")){
            int id=Integer.parseInt(confId);
            HotelService hotelService=new HotelServiceImpl();
            Living living=hotelService.viewLiving(id);
            req.setAttribute("living",living);
            try{
                req.getRequestDispatcher(url).forward(req,resp);
            }catch (IOException | ServletException e){
                e.printStackTrace();
            }
        }

    }
    //修改住宿信息
    public void modifyLiving(HttpServletRequest req, HttpServletResponse resp,String url1,String url2,int flag){
        String confId=req.getParameter("confId");
        String roomId=req.getParameter("roomId");
        String startTime=req.getParameter("startTime");
        String endTime=req.getParameter("endTime");
        String response=req.getParameter("response");
        Living living=new Living();
        int cid=Integer.valueOf(confId);
        int rid=Integer.valueOf(roomId);
        int sign=Integer.valueOf(flag);
        living.setConfId(cid);
        living.setRoomId(rid);
        living.setFlag(flag);
        living.setResponse(response);
        Object attribute = req.getSession().getAttribute(Constants.HOTEL_SESSION);
        if(attribute!=null){
            living.setHotelId(Integer.valueOf(((Hotel)attribute).getHotelId()));
        }else{
            try{
                resp.sendRedirect(req.getContextPath()+"/jsp/hotelJsp/login.jsp");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        try {
            living.setStartTime(new SimpleDateFormat("yyyy-MM-dd").parse(startTime));
            living.setEndTime(new SimpleDateFormat("yyyy-MM-dd").parse(endTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try{
            HotelService hotelService=new HotelServiceImpl();
            if(hotelService.modifyLiving(living)){
                resp.sendRedirect(req.getContextPath()+url1);
            }else{
                req.getRequestDispatcher(url2).forward(req, resp);
            }
        }catch(IOException | ServletException e){
            e.printStackTrace();
        }
    }

}
