package controller.conferee;


import dao.confereeDao.UserDao;
import dao.confereeDao.impl.HotelDaoImpl;
import dao.confereeDao.impl.UserDaoImpl;
import service.confereeService.HotelService;
import service.confereeService.impl.HotelServiceImpl;
import vo.confereeVo.Hotel;
import vo.confereeVo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class BookHotelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Hotel hotel=new Hotel();
        HotelDaoImpl hotelDao=new HotelDaoImpl();
        String HotelId=req.getParameter("hotelId");
        hotel=hotelDao.GetHotel(Integer.parseInt(HotelId));

        DateFormat DateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date endtime = Date.valueOf(req.getParameter("endtime"));
        Date starttime = Date.valueOf(req.getParameter("starttime"));

        String description=req.getParameter("description");

        hotel.setStarttime(starttime);
        hotel.setEndtime(endtime);
        hotel.setDescription(description);



        HotelService hotelService=new HotelServiceImpl();
        UserDao userDao=new UserDaoImpl();
        String username=(String)session.getAttribute("username");
        String password=(String)session.getAttribute("password");
        User user=new User();
        user=userDao.queryUserByUsernameAndPassword(username,password);

        hotelService.bookHotel(hotel,user);

        req.getRequestDispatcher("/jsp/confereeJsp/BookHotelsuccess.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
