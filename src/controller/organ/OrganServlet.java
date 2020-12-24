package controller.organ;

import com.google.gson.Gson;
import service.organService.ExistorganidService;
import service.organService.OrganService;
import service.organService.OrganServiceImpl;
import vo.organVo.Organ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/organ/organServlet")
public class OrganServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method=request.getParameter("method");
        System.out.println(method);
        if(method.equals("modifyPassword")&&method!=null){
            this.modifyPassword(request,response);
        }else if(method.equals("existOrganid")&&method!=null){
            this. existOrganid(request, response);
        }
    }


    public void  modifyPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrganService os=new OrganServiceImpl();
        String newPassword = request.getParameter("newPassword");
        HttpSession session = request.getSession();
        Organ organ1 = (Organ) session.getAttribute("organ1");
        System.out.println(organ1.getOrgan_id());
        Integer organ_id = organ1.getOrgan_id();
        boolean b = os.modifyPassword(organ_id, newPassword);
        Map<String,Integer> result=new HashMap<>();
        if(b){
            result.put("result",1);
            System.out.println("修改成功！");
        }else {
            result.put("result",0);
            System.out.println("修改失败！");
        }
        Gson gson=new Gson();
        String s = gson.toJson(result);
        response.getWriter().write(s);
    }

    public void existOrganid(HttpServletRequest request,HttpServletResponse response) throws IOException {

        int organid= Integer.parseInt(request.getParameter("organId"));
        ExistorganidService exi=new ExistorganidService();
        boolean eflag=new ExistorganidService().existOrganId(organid);
        Map<String,Integer> result=new HashMap<String,Integer>();
        //
        if(eflag){
            result.put("result",1);
        }else {
            result.put("result",0);
        }
        Gson gson = new Gson();
        String json = gson.toJson(result);
        response.getWriter().write(json);

    }
}
