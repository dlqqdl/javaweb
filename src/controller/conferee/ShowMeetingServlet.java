package controller.conferee;

import dao.confereeDao.UserDao;
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
import java.util.ArrayList;
import java.util.List;

public class ShowMeetingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MeetingService meetingService=new MeetingServiceImpl();
        List<Meeting> meetingList = new ArrayList<Meeting>();
        UserDao userDao=new UserDaoImpl();

        HttpSession session=req.getSession();
        String username=(String)session.getAttribute("username");
        String password=(String)session.getAttribute("password");


        User user=new User();
        user=userDao.queryUserByUsernameAndPassword(username,password);
        req.setAttribute("user",user);
        meetingList = meetingService.viewMyBookingInfo(user);

        req.setAttribute("meetingList",meetingList);//该用户参加的所有会议
        req.getRequestDispatcher("/jsp/confereeJsp/showmeeting.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
