package service.confereeService;

import vo.confereeVo.Meeting;
import vo.confereeVo.User;

import java.util.List;

public interface MeetingService {

    /**
     * 预定会议
     * @param meeting
     * @param user
     */
    public void bookMeeting(Meeting meeting, User user);

    /**
     * 取消会议
     * @param meeting
     * @param user
     */
    public void cancelMeeting(Meeting meeting,User user);

    /**
     * 查询当前用户预定的所有会议
     * @param
     * @return
     */
    public List<Meeting> viewMyBookingInfo(User user);

    /**
     * 显示所有会议信息
     * @return
     */
    public List<Meeting> ShowAllmeetings();

}
