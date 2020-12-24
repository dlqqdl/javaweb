package service.organService;

import dao.organDao.SelectMymeetingDao;
import vo.organVo.Meeting;
import java.util.List;

public class MymeetingService {

    public List<Meeting> myMeet(int userid){
        SelectMymeetingDao mymeetingDao=new SelectMymeetingDao();
        List<Meeting> list=mymeetingDao.selectMymeet(userid);
        return list;
    }
}

