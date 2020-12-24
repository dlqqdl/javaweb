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
import java.util.ArrayList;
import java.util.List;

public class DriverConfController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] con=request.getParameterValues("inputpc");
        if(con!=null){
            HttpSession session=request.getSession();
            PickService pickService=new PickService();
            Driver driver=(Driver)session.getAttribute("driveronline");
            List<Pick> picks=pickService.findPassConfirm(driver.getDriver_id());
            List<Pick> pickList=new ArrayList<Pick>();
            for(int i=0;i<con.length;i++){
                pickList.add(picks.get(Integer.parseInt(con[i])));
            }
            pickService.driverconfirm(pickList);
            request.getRequestDispatcher("/jsp/driverJsp/success.jsp").forward(request,response);
        }
        else{
            request.getRequestDispatcher("/jsp/driverJsp/workless.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
