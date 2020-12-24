package dao.organDao;



import vo.organVo.Conferee;

import java.util.List;

public interface AttendMeetingDao {

    public List<Conferee> getConf(int meetid);
}
