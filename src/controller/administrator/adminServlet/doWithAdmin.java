package controller.administrator.adminServlet;


import service.administratorService.adminService;
import vo.administratorVo.Admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class doWithAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getFunction(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getFunction(request,response);
    }
    public void getFunction(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String method=request.getParameter("method");
        if(method.equals("showAllAdmin")){
            showAllAdmin(request,response);
            return;
        }
        else if(method.equals("showAdmin")){
            showAdmin(request,response);
        }
    }
    private void showAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        adminService service=new adminService();
        String temp=request.getParameter("adminId");
        int id=Integer.parseInt(temp);
        List<Admin> adminList=service.showAdmin(id);
        response.setContentType("text/xml;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("adminList",adminList);
        request.getRequestDispatcher("/jsp/administratorJsp/showAdmin.jsp").forward(request,response);
    }

    private void showAllAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        adminService service=new adminService();
        List<Admin> adminList=service.showAllAdmin();
        response.setContentType("text/xml;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("adminList",adminList);
        request.getRequestDispatcher("/jsp/administratorJsp/showAdmin.jsp").forward(request,response);
    }
}
