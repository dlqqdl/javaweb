package controller.administrator.hotelServlet;

import service.administratorService.hotelService;
import vo.administratorVo.Hotel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class doWithHotel extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
           getFunction(request,response);
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            getFunction(request,response);
        }
    public void getFunction(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String method=request.getParameter("method");
        if(method.equals("showAllHotel")){
            showAllHotel(request,response);
            return;
        }
        else if(method.equals("addNewHotel")){
            addNewHotel(request,response);
            return;
        }
        else if(method.equals("deleteHotel")){
            deleteHotel(request,response);
            return;
        }
        else if(method.equals("showOneHotel")){
            showOneHotel(request,response);
            return;
        }
    }

    private void showAllHotel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hotelService service=new hotelService();
        List<Hotel> hotelList=service.showAllHotel();
        response.setContentType("text/xml;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("hotelList",hotelList);
        request.getRequestDispatcher("/jsp/administratorJsp/showAllHotel.jsp").forward(request,response);
    }
    private void deleteHotel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            hotelService service=new hotelService();
            String temp_id=request.getParameter("hotel_id");
            int id=Integer.parseInt(temp_id);
            String name=request.getParameter("hotel_name");
            boolean result=service.deleteHotel(id,name);
            if(result) request.setAttribute("deleteHotelResult",true);
            else request.setAttribute("deleteHotelResult",false);
            request.getRequestDispatcher("/jsp/administratorJsp/deleteHotel.jsp").forward(request,response);
    }
    private void addNewHotel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hotelService service=new hotelService();
        response.setContentType("text/xml;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        int hotel_id=Integer.parseInt(request.getParameter("hotel_id"));//id
        String names=request.getParameter("names");//酒店名字
        String address=request.getParameter("address");//地址
        int tel=Integer.parseInt(request.getParameter("tel"));//联系电话
        int rooms=Integer.parseInt(request.getParameter("rooms"));//可用房间数
        String password=request.getParameter("password");//登录密码
        Hotel hotel=new Hotel(hotel_id,names,address,tel,rooms,password);
        boolean addHotelResult=service.addOneHotel(hotel);
        if(addHotelResult)
            request.setAttribute("addHotelResult",true);
        else
            request.setAttribute("addHotelResult",false);
        request.getRequestDispatcher("/jsp/administratorJsp/addNewHotel.jsp").forward(request,response);
    }
    private void showOneHotel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hotelService service=new hotelService();
        String name=request.getParameter("hotelName");
        List<Hotel> hotelList=service.searchHotel(name);
        response.setContentType("text/xml;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("hotelList",hotelList);
        request.getRequestDispatcher("/jsp/administratorJsp/showAllHotel.jsp").forward(request,response);
    }

}
