package controller.conferee;

import dao.confereeDao.UserDao;
import dao.confereeDao.impl.UserDaoImpl;
import service.confereeService.UserService;
import service.confereeService.impl.UserServiceImpl;
import vo.confereeVo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ShowUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService=new UserServiceImpl();
        User user=new User();
        UserDao userDao=new UserDaoImpl();

        HttpSession session=req.getSession();
        String username=(String)session.getAttribute("username");
        String password=(String)session.getAttribute("password");

        user=userDao.queryUserByUsernameAndPassword(username,password);

        req.setAttribute("user",user);
        req.getRequestDispatcher("/jsp/confereeJsp/showuser.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
