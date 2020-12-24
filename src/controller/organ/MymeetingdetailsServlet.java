package controller.organ;

import service.organService.AttendmeetingService;
import vo.organVo.Conferee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/organ/mymeetingdetailsServlet")
public class MymeetingdetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int mtid=0;
        if(request.getParameter("mtid")==null){
            mtid=(int) request.getAttribute("mtid");
        }else {
            mtid= Integer.parseInt(request.getParameter("mtid"));
        }

        System.out.println("mymeetingdetailsServlet+mtid"+mtid);
//        System.out.println(mtid+"aaaa");
//        MymeetingService mms=new MymeetingService();
//        List<Meeting> list = mms.myMeet(mtid);
//        System.out.println("wnima");
//        request.setAttribute("list",list);
        AttendmeetingService ams=new AttendmeetingService();
        List<Conferee> attendconf = ams.attendconf(mtid);
        request.setAttribute("attconf",attendconf);
        request.setAttribute("mtid2",mtid);
        request.getRequestDispatcher("/jsp/organJsp/meetingdetails.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
