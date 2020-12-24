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

public class ChoPassController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(session.getAttribute("driveronline")==null){
            request.getRequestDispatcher("/jsp/driverJsp/beylimit.jsp").forward(request,response);
        }
        else {
            PickService pickService = new PickService();
            String[] chomul = request.getParameterValues("multi");
            String chospe = request.getParameter("special");
            String[] chooth = request.getParameterValues("other");
            List<Pick> picks = null;
            Object obj = session.getAttribute("list");
            if (obj instanceof List) {
                picks = (List<Pick>) obj;
            }
            for (int i = 0; i < picks.size(); i++) {
                System.out.println(picks.get(i).getDescription());
            }
            List<Pick> pickList = new ArrayList<Pick>();
//            System.out.println("zzzzzzzz");
//            System.out.println(chospe);
//            System.out.println(chomul==null);
//            System.out.println(chospe!=null);
            if (chomul!= null) {
                for (int i = 0; i < chomul.length; i++) {
                    pickList.add(picks.get(Integer.parseInt(chomul[i])));
                }
                Driver driver=(Driver)session.getAttribute("driveronline");
                int my=driver.getDriver_id();
//                System.out.println(my);
                pickService.updatestatus(pickList,my);
                request.getRequestDispatcher("/jsp/driverJsp/success.jsp").forward(request, response);//成功
            }
            else if(chospe!=null){
                pickList.add(picks.get(Integer.parseInt(chospe)));
                Driver driver=(Driver)session.getAttribute("driveronline");
                int my=driver.getDriver_id();
                pickService.updatestatus(pickList,my);
                request.getRequestDispatcher("/jsp/driverJsp/success.jsp").forward(request, response);//成功
            }
            else if(chooth.length!=0){}//其他，待定
        }}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
