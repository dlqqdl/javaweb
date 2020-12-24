package controller.administrator;

import service.administratorService.adminService;
import vo.administratorVo.Admin;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class modifyPassword extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        adminService adminServ=new adminService();
        response.setContentType("text/xml;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        String accountTemp=request.getParameter("account");
        int account=Integer.parseInt(accountTemp);
        String password= request.getParameter("oldPassword");
        String newPassword=request.getParameter("newPassword");
        Admin admin=adminServ.checkIsAdministrator(new Admin(account,null,password));
        boolean result=false;
        if(admin!=null){
            admin.setPassword(newPassword);
            result=adminServ.modifyPassword(admin);
            if(result)
                request.setAttribute("resultMsg",true);
            else
                request.setAttribute("resultMsg",false);
        }
        else
            request.setAttribute("resultMsg",false);
        request.getRequestDispatcher("/jsp/administratorJsp/dealModify.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException { return;}
}
