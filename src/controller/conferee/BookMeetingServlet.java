package controller.conferee;

import dao.confereeDao.UserDao;
import dao.confereeDao.impl.MeetingDaoImpl;
import dao.confereeDao.impl.UserDaoImpl;
import service.confereeService.MeetingService;
import service.confereeService.impl.MeetingServiceImpl;
import vo.confereeVo.Meeting;
import vo.confereeVo.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 预定会议控制器
 * @author Administrator
 *
 */
public class BookMeetingServlet extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        MeetingService meetingService=new MeetingServiceImpl();
        Meeting meeting=new Meeting();

        MeetingDaoImpl meetingDao=new MeetingDaoImpl();
        String MeetId=request.getParameter("meet_id");
        int Meet_id=Integer.parseInt(MeetId);
        meeting=meetingDao.GetMeeting(Meet_id);

        UserDao userDao=new UserDaoImpl();
        String username=(String)session.getAttribute("username");
        String password=(String)session.getAttribute("password");
        User user=new User();

        user=userDao.queryUserByUsernameAndPassword(username,password);

        meetingService.bookMeeting(meeting,user);


        request.getRequestDispatcher("/jsp/confereeJsp/BookMeetingsuccess.jsp").forward(request,response);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}