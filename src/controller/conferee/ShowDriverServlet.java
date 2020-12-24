package controller.conferee;

import dao.confereeDao.DriverDao;
import dao.confereeDao.UserDao;
import dao.confereeDao.impl.DriverDaoImpl;
import dao.confereeDao.impl.UserDaoImpl;
import service.confereeService.impl.DriverServiceImpl;
import vo.confereeVo.Driver;
import vo.confereeVo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ShowDriverServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DriverServiceImpl driverService=new DriverServiceImpl();
        Driver driver=new Driver();
        DriverDao driverDao=new DriverDaoImpl();
        UserDao userDao=new UserDaoImpl();
        HttpSession session=req.getSession();
        String username=(String)session.getAttribute("username");
        String password=(String)session.getAttribute("password");


        User user=userDao.queryUserByUsernameAndPassword(username,password);


        driver=driverService.getDriver(user);

//        if (driver==null)
//            System.out.println("driver为空！！！！");

        req.setAttribute("driver",driver);

        req.getRequestDispatcher("/jsp/confereeJsp/showdriver.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
