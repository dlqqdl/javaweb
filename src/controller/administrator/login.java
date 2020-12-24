package controller.administrator;

import service.administratorService.adminService;
import vo.administratorVo.Admin;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        adminService admin=new adminService();
        HttpSession session=request.getSession();
        response.setContentType("text/xml;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        String password=request.getParameter("password");
        String accountTemp=request.getParameter("account");
        int account=Integer.parseInt(accountTemp);
        Admin admin1=new Admin(account,null,password);
        Admin result=admin.checkIsAdministrator(admin1);
        if (result!=null){
            session.setAttribute("loginResult", true);
            session.setAttribute("admin",admin1);
            request.getRequestDispatcher("/jsp/administratorJsp/management.jsp").forward(request,response);
        }
        else {
            session.setAttribute("loginResult", false);
            request.getRequestDispatcher("/jsp/administratorJsp/login.jsp").forward(request,response);
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {}
}
