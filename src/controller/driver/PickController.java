package controller.driver;

import service.driverService.PickService;
import vo.driverVo.Driver;
import vo.driverVo.Pick;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class PickController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(session.getAttribute("driveronline")==null){
            request.getRequestDispatcher("/jsp/driverJsp/beylimit.jsp").forward(request,response);
        }
        Driver driver=(Driver)session.getAttribute("driveronline");
        PickService pickService=new PickService();
        List<Pick> special=pickService.findsingle(driver.getDriver_id());
        List<Pick> coach=pickService.findcrowded(driver.getDriver_id());
        List<Pick> other=pickService.findother(driver.getDriver_id());
        String choice=request.getParameter("sel");
        request.setAttribute("type",choice);
        if(choice.equals("special")){
            request.setAttribute("list",special);
            session.setAttribute("list",special);
            System.out.println("yyyyyyyyyy");
        }
        else if(choice.equals("coach")){
            request.setAttribute("list",coach);
            session.setAttribute("list",coach);
        }
        else if(choice.equals("other")){
            request.setAttribute("list",other);
            session.setAttribute("list",other);
        }
        request.getRequestDispatcher("/jsp/driverJsp/waittingp.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
