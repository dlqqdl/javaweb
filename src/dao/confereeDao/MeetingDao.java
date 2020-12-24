package dao.confereeDao;

import vo.confereeVo.Meeting;
import vo.confereeVo.User;

import java.util.List;

public interface MeetingDao {
    /**
     * 查询某员工预定的所有会议
     * @param user
     * @return
     */
    public List<Meeting> SelctAllMeetingsByUser(User user);

    /**
     * 显示所有会议
     * @return
     */
    public List<Meeting> ShowAllMeetings();

    /**
     * 预定会议
     * @param user
     */
    public void Insert(Meeting meeting,User user);

    /**
     * 取消会议
     * @param meeting
     * @param user
     */
    public void Cancel(Meeting meeting,User user);

    /**
     * 根据会议名获取会议对象
     * @param meetingname 会议名称
     * @return
     */
    public Meeting GetMeeting(int meetingname);
}
