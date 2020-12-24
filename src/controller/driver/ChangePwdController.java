package controller.driver;

import service.driverService.DriverService;
import vo.driverVo.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangePwdController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Driver driver = (Driver) session.getAttribute("driveronline");
        DriverService driverService = new DriverService();
        int id = driver.getDriver_id();
        String pwd = request.getParameter("newPassword");
        String oldpwd = request.getParameter("oldPassword");
        String op = driver.getPassword();
        if (!oldpwd.equals(op)) {
            request.getRequestDispatcher("/jsp/driverJsp/fail.jsp").forward(request, response);
        } else {
            int i = 0;
            i = driverService.changePwd(id, pwd);
            if (i == 1) {
                request.getRequestDispatcher("/driverLogout").forward(request, response);
            } else {
                request.getRequestDispatcher("/jsp/driverJsp/fail.jsp").forward(request, response);
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
