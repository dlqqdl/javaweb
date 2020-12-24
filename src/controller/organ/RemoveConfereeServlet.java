package controller.organ;

import dao.organDao.test.RemoveConfereeDao;
import service.organService.RemoveConfereeService;
import service.organService.RemoveMeetingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/organ/removeConfereeServlet")
public class RemoveConfereeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int confid = Integer.parseInt(request.getParameter("conf_id"));
        RemoveConfereeService service=new RemoveConfereeService();
        service.removeConferee(confid);
        int mtid3 = Integer.parseInt(request.getParameter("mt_id2"));
        request.setAttribute("mtid",mtid3);
        System.out.println(mtid3);
        request.getRequestDispatcher("/organ/mymeetingdetailsServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
