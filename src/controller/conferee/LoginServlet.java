package controller.conferee;

import service.confereeService.UserService;
import service.confereeService.impl.UserServiceImpl;
import vo.confereeVo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session=req.getSession();
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(username,password));
        boolean flag1=false;
        // 如果等于null,说明登录 失败!
        if (loginUser == null) {
            flag1=true;
            req.setAttribute("flag1",flag1);
            //   跳回登录页面
            req.getRequestDispatcher("/jsp/confereeJsp/login.jsp").forward(req, resp);
        } else {
            flag1=false;
            // 登录 成功
            //跳到成功页面login_success.html
            User user=userService.login(new User(username,password));
            session.setAttribute("user",user);
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            req.getRequestDispatcher("/jsp/confereeJsp/login_success.jsp").forward(req, resp);
        }
    }
}

