package controller.organ;


import com.google.gson.Gson;
import service.organService.AddmeetingService;
import vo.organVo.Meeting;
import vo.organVo.Organ;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/organ/addMeetingServlet")
public class AddMeetingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        addMeet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        addMeet(request, response);
    }

    protected void addMeet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        int meetid2 = Integer.parseInt(request.getParameter("meetid2"));
        System.out.println(meetid2);
        String meettopic2 = request.getParameter("meettopic2");
        int meetnum2 = Integer.valueOf(request.getParameter("meetnum2"));
        Date stime2 = Date.valueOf(request.getParameter("stime2"));
        Date etime2 = Date.valueOf(request.getParameter("etime2"));
        String meetaddress2 = request.getParameter("meetaddress2");
        HttpSession session = request.getSession();
        Organ organ1 = (Organ) session.getAttribute("organ1");
        System.out.println(meetaddress2);
        Meeting meeting = new Meeting(meetid2, organ1.getOrgan_id(), meettopic2, meetnum2, stime2, etime2, meetaddress2);
        System.out.println(meetnum2);

        AddmeetingService addmeetingService = new AddmeetingService();
        int flag = addmeetingService.addmeeting(meeting);
        request.setAttribute("flag1", flag);
        Map<String, Integer> result1 = new HashMap<String, Integer>();
        System.out.println(flag);
        if (flag == 0) {
            result1.put("result2", 0);
        } else {
            result1.put("result2", 1);
        }

        Gson gson = new Gson();
        String json = gson.toJson(result1);
        response.getWriter().write(json);
//      request.getRequestDispatcher("/meetAdd.jsp").forward(request,response);
    }
}
