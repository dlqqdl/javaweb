package service.confereeService.impl;

import dao.confereeDao.MeetingDao;
import dao.confereeDao.impl.MeetingDaoImpl;
import service.confereeService.MeetingService;
import vo.confereeVo.Meeting;
import vo.confereeVo.User;

import java.sql.Timestamp;
import java.util.List;

/**
 * 会议:对外提供的服务类
 * @author Administrator
 */
public class MeetingServiceImpl implements MeetingService{

    @Override
    public void bookMeeting(Meeting meeting, User user) {

        MeetingDao meetingDao=new MeetingDaoImpl();
        meetingDao.Insert(meeting,user);
    }

    @Override
    public void cancelMeeting(Meeting meeting, User user) {
        MeetingDao meetingDao=new MeetingDaoImpl();
        meetingDao.Cancel(meeting,user);
    }

    @Override
    public List<Meeting> viewMyBookingInfo(User user) {
        MeetingDao meetingDao=new MeetingDaoImpl();
        return meetingDao.SelctAllMeetingsByUser(user);
    }

    @Override
    public List<Meeting> ShowAllmeetings() {
        MeetingDao meetingDao=new MeetingDaoImpl();
        return meetingDao.ShowAllMeetings();
    }
}
