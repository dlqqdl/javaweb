package service.driverService;

import dao.driverDao.DriverDao;
import dao.driverDao.impl.DriverDaoImpl;
import vo.driverVo.Driver;

import java.util.List;

public class DriverService {
    private DriverDao driverDao=new DriverDaoImpl();
    public Driver findDriver(int id){
        return driverDao.findDriver(id);
    }
    public int getDriver(int id,String pwd){
        return driverDao.getDriver(id,pwd);
    }
    public int changePwd(int id, String pwd){return driverDao.changePwd(id,pwd);}
    public int Signup(int id, int tel, String name, String pwd){return driverDao.Signup(id,tel,name,pwd);}
    public int setStatus(int id,int status){return driverDao.setStatus(id,status);}
}
