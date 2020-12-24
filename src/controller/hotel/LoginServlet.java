package controller.hotel;

import service.HotelService.HotelService;
import service.HotelService.HotelServiceImpl;
import util.Constants;
import vo.hotelVo.Hotel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Timgreat
 * @date 2020/11/23 - 22:15
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        //String role=req.getParameter("role");
//        if(role.equals("hotel")){
//
//        }
        HotelService hotelService=new HotelServiceImpl();
        Hotel hotel=hotelService.login(name,password);
        if(hotel!=null){
            //将用户信息放入Session
            req.getSession().setAttribute(Constants.HOTEL_SESSION,hotel);
            resp.sendRedirect("jsp/hotelJsp/jsp/frame.jsp");
        }else{
            req.setAttribute("error","用户名或密码不正确！");
            req.getRequestDispatcher("jsp/hotelJsp/login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
