package controller.driver;

import service.driverService.DriverService;
import vo.driverVo.Driver;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeStatusController extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String choice=request.getParameter("sels");
        DriverService driverService=new DriverService();
        HttpSession session=request.getSession();
        Driver driver=(Driver)session.getAttribute("driveronline");
        if(choice.equals("busy")){
            session.setAttribute("driverstatus",1);
            driverService.setStatus(driver.getDriver_id(),1);
        }
        else if(choice.equals("leisure")){
            session.setAttribute("driverstatus",0);
            driverService.setStatus(driver.getDriver_id(),0);
        }
        request.getRequestDispatcher("/jsp/driverJsp/changestatus.jsp").forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
