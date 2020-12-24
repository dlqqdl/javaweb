package controller.organ;

import service.organService.RemoveMeetingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/organ/removeMeetingServlet")
public class RemoveMeetingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int mtid = Integer.parseInt(request.getParameter("mtid"));
        RemoveMeetingService service = new RemoveMeetingService();
        service.removeMeeting(mtid);
        request.getRequestDispatcher("/organ/myMeetingServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
