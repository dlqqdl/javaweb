package service.organService;


import dao.organDao.RegisterDao;
import vo.organVo.Organ;

public class RegisterService {
    public int regist(Organ organ){
        RegisterDao rd=new RegisterDao();
        return rd.insertorgan(organ);
    }
}
