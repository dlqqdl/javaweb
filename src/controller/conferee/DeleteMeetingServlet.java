package controller.conferee;

import dao.confereeDao.UserDao;
import dao.confereeDao.impl.MeetingDaoImpl;
import dao.confereeDao.impl.UserDaoImpl;
import service.confereeService.MeetingService;
import service.confereeService.impl.MeetingServiceImpl;
import vo.confereeVo.Meeting;
import vo.confereeVo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteMeetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        MeetingService meetingService=new MeetingServiceImpl();
        Meeting meeting=new Meeting();
        MeetingDaoImpl meetingDao=new MeetingDaoImpl();

        meeting=meetingDao.GetMeeting(Integer.parseInt(req.getParameter("meetId")));

        UserDao userDao=new UserDaoImpl();
        String username=(String)session.getAttribute("username");
        String password=(String)session.getAttribute("password");
        User user=new User();

        user=userDao.queryUserByUsernameAndPassword(username,password);

        meetingService.cancelMeeting(meeting,user);


        req.getRequestDispatcher("/jsp/confereeJsp/CancelMeetingsuccess.jsp").forward(req,resp);
    }
}
