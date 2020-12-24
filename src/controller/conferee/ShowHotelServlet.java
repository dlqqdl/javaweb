package controller.conferee;

import dao.confereeDao.HotelDao;
import dao.confereeDao.impl.HotelDaoImpl;
import dao.confereeDao.impl.UserDaoImpl;
import service.confereeService.impl.HotelServiceImpl;
import vo.confereeVo.Hotel;
import vo.confereeVo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ShowHotelServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HotelServiceImpl hotelService=new HotelServiceImpl();
        Hotel hotel =new Hotel();
        HotelDao hotelDao=new HotelDaoImpl();
        UserDaoImpl userDao=new UserDaoImpl();

        HttpSession session=req.getSession();
        String username=(String)session.getAttribute("username");
        String password=(String)session.getAttribute("password");

        System.out.println("username="+username+"password="+password);
        User user=userDao.queryUserByUsernameAndPassword(username,password);

        hotel =hotelService.viewMyHotelInfo(user);

        req.setAttribute("hotel", hotel);
        req.getRequestDispatcher("/jsp/confereeJsp/showhotel.jsp").forward(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
