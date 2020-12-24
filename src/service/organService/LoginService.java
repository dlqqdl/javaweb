package service.organService;

import dao.organDao.LoginDao;
import vo.organVo.Organ;

public class LoginService {
    Organ organ=new Organ();
    public int confirm(Organ organ){
        LoginDao loginDao=new LoginDao();
        int i = loginDao.believe(organ);
        return i;
    }

    public Organ getDetail(String name){
        Organ organ=new Organ();
        LoginDao loginDao=new LoginDao();
        organ=loginDao.getid(name);
        return organ;
    }
}
