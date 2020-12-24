package controller.driver;

import service.driverService.DriverService;
import vo.driverVo.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SignupController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("driverid"));
        String name = request.getParameter("dname");
        String pwd = request.getParameter("newPassword");
        int tel = Integer.parseInt(request.getParameter("tel"));
        int i = 0;
        DriverService driverService = new DriverService();
        i = driverService.Signup(id, tel, name, pwd);
        if (i != 0) {
            request.getRequestDispatcher("/jsp/driverJsp/login.jsp").forward(request, response);
        } else {
            request.setAttribute("signupResult",false);
            request.getRequestDispatcher("/jsp/driverJsp/signup.jsp").forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
