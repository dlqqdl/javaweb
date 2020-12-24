package service.organService;


import dao.organDao.AddmeetDao;
import vo.organVo.Meeting;

public class AddmeetingService {
     AddmeetDao addmeetDao=new AddmeetDao();
     public int addmeeting(Meeting meeting){
         int insFlag=0;
         insFlag=addmeetDao.insert(meeting);
         return insFlag;
     }
}
