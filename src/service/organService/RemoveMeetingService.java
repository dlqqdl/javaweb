package service.organService;


import dao.organDao.impl.RemoveMeetingDaoImpl;

public class RemoveMeetingService {

    public int removeMeeting(int meetid){
        RemoveMeetingDaoImpl removeMeetingDao=new RemoveMeetingDaoImpl();
        int i = removeMeetingDao.removeMeeting(meetid);
        return i;
    }

}
