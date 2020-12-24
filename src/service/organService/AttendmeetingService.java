package service.organService;


import dao.organDao.AttendMeetingDao;
import dao.organDao.impl.AttendMeetingDaoImpl;
import vo.organVo.Conferee;

import java.util.List;

public class AttendmeetingService {
    AttendMeetingDao attendMeetingDao=new AttendMeetingDaoImpl();
    public List<Conferee> attendconf(int meetid){
        List<Conferee> conf = attendMeetingDao.getConf(meetid);
        return conf;
    }
}
