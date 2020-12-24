package controller.organ;

import service.organService.MymeetingService;
import vo.organVo.Organ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/organ/myMeetingServlet")
public class MyMeetingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Organ organ1 = (Organ) session.getAttribute("organ1");
        MymeetingService mymeetingService=new MymeetingService();
        List list = mymeetingService.myMeet(organ1.getOrgan_id());
        session.setAttribute("list",list);
        request.getRequestDispatcher("/jsp/organJsp/meetlist.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
