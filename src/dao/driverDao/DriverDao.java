package dao.driverDao;

import vo.driverVo.Driver;

import java.util.List;

public interface DriverDao {
    public int getDriver(int id,String pwd);
    public Driver findDriver(int id);
    public int changePwd(int id,String pwd);
    public int Signup(int id,int tel,String name,String pwd);
    public int setStatus(int id,int status);
}
