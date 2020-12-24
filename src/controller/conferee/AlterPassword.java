package controller.conferee;

import service.confereeService.impl.UserServiceImpl;
import vo.confereeVo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AlterPassword extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reNewPassword = req.getParameter("reNewPassword");
        UserServiceImpl userService=new UserServiceImpl();
        HttpSession httpSession=req.getSession();
        User user=(User)httpSession.getAttribute("user");
        user.setPassword(reNewPassword);

        userService.updatePassword(user);
        req.getRequestDispatcher("/jsp/confereeJsp/login.jsp").forward(req, resp);
    }
}
