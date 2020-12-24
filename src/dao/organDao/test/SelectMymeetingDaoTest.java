//package dao.organDao.test;
//
//import com.cn.dazuoye.dao.*;
//import com.cn.dazuoye.dao.impl.AttendMeetingDaoImpl;
//import com.cn.dazuoye.dao.impl.OrganDaoImpl;
//import com.cn.dazuoye.dao.impl.RemoveMeetingDaoImpl;
//import com.cn.dazuoye.model.Conferee;
//import com.cn.dazuoye.model.Meeting;
//import com.cn.dazuoye.model.Organ;
//import org.junit.Test;
//
//import java.sql.Date;
//import java.util.List;
//
//public class SelectMymeetingDaoTest {
//    @Test
//    public void test1() {
//        SelectMymeetingDao selectMymeetingDao=new SelectMymeetingDao();
//        List<Meeting> list=selectMymeetingDao.selectMymeet(64);
//        int i;
//        for(i=0;i<list.size();i++){
//            System.out.println(list.get(i).getMeet_id());
//            System.out.println(list.get(i).getEnd_time());
//            System.out.println("�����ϣ�");
//        }
//    }
//
//    @Test
//    public void test2(){
//        RegisterDao rd=new RegisterDao();
//        rd.insertorgan(new Organ(2,"A",131,"AAA"));
//    }
//
//    @Test
//    public void test3(){
//        LoginDao ld=new LoginDao();
//        ld.believe(new Organ(2,"A",131,"AAA"));
//    }
//
//    @Test
//    public void test4(){
//        AddmeetDao ad=new AddmeetDao();
//        Meeting meet=new Meeting();
//        meet.setAddress("china");
//
//        meet.setEnd_time(new Date(10,1,1));
//        meet.setTopic("ahhah");
//        meet.setOrgan_id(82);
//        //1899.12.30
//        Date date=new Date(0,0,0);
//        long time = date.getTime();
//        meet.setStart_time(new Date(time));
//        meet.setNum_att(20);
//        meet.setMeet_id(4);
//        ad.insert(meet);
//    }
//
//    @Test
//    public void test5(){
//        AttendMeetingDaoImpl attendMeetingDao=new AttendMeetingDaoImpl();
//        List<Conferee> conf = attendMeetingDao.getConf(1);
//        System.out.println(conf.get(0).getConf_id());
//
//    }
//
//    @Test
//    public void test6(){
//        OrganDaoImpl odi=new OrganDaoImpl();
//        odi.existOrganId(1);
//    }
//
//    @Test
//    public void test7(){
//        RemoveMeetingDaoImpl removeMeetingDao=new RemoveMeetingDaoImpl();
//        removeMeetingDao.removeMeeting(46);
//    }
//    @Test
//    public void test8(){
//        OrganDao organDao=new OrganDaoImpl();
//        organDao.modifyPassword(1,"777");
//    }
//}
