package service.organService;


import dao.organDao.UnDriverDao;
import dao.organDao.impl.UnDriverDaoImpl;
import vo.organVo.Driver;

import java.util.List;

/**
 * @Author ExilePluto
 * @Date 2020/12/21
 */
public class DriverServiceImpl implements DriverService{
    @Override
    public List<Driver> unDriver(int flag) {
        UnDriverDao udd=new UnDriverDaoImpl();
        List<Driver> undriver = udd.undriver(flag);
        return undriver;
    }

    @Override
    public int changeDriverstate(int did) {
        UnDriverDao udd=new UnDriverDaoImpl();
        int i = udd.changeDriverstate(did);
        return i;
    }
}
