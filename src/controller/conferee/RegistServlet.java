package controller.conferee;

import service.confereeService.UserService;
import service.confereeService.impl.UserServiceImpl;
import vo.confereeVo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String tel =req.getParameter("tel");
        int telephone =Integer.parseInt(tel);
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        UserService userService=new UserServiceImpl();
//        2、检查 验证码是否正确  === 写死,要求验证码为:abcde

        if ("abcde".equalsIgnoreCase(code)) {

//        3、检查 用户名是否可用
            boolean flag=false;
            if (userService.existUsername(username)) {
                flag=true;
                req.setAttribute("flag",flag);
                System.out.println("用户名[" + username + "]已存在!");
//        跳回注册页面
                req.getRequestDispatcher("/jsp/confereeJsp/regist.jsp").forward(req, resp);
            } else {
                //      可用
//                调用Sservice保存到数据库
                flag=false;
                userService.registUser(new User( username, password, telephone,sex,email));
//
//        跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("/jsp/confereeJsp/regist_success.jsp").forward(req, resp);
            }
        } else {
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/jsp/confereeJsp/regist.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
