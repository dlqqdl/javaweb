package service.confereeService.impl;

import dao.confereeDao.DriverDao;
import dao.confereeDao.impl.DriverDaoImpl;
import service.confereeService.DriverService;
import vo.confereeVo.Driver;
import vo.confereeVo.User;

public class DriverServiceImpl implements DriverService {


    @Override
    public Driver getDriver(User user) {
        DriverDao driverDao=new DriverDaoImpl();
        Driver driver=driverDao.queryDriver(user);
        return driver;
    }
}
