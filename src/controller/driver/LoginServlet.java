package controller.driver;

import service.driverService.DriverService;
import vo.driverVo.Driver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int usename= Integer.parseInt(request.getParameter("usename"));
        String pwd=request.getParameter("pwd");
        Driver driver=new Driver(usename,pwd);
        HttpSession session=request.getSession();
        DriverService driverService=new DriverService();
        int i=driverService.getDriver(usename,pwd);
        if(i==1){
            Driver driver1=driverService.findDriver(usename);
            session.setAttribute("driveronline",driver1);
            session.setAttribute("driverstatus",driver1.getDflag());
            request.getRequestDispatcher("/jsp/driverJsp/index.jsp").forward(request,response);
        }
        else {
            request.setAttribute("loginResult",false);
            request.getRequestDispatcher("/jsp/driverJsp/login.jsp").forward(request,response);
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
