package service.administratorService;

import dao.administratorDao.impl.driverDaoImpl;
import vo.administratorVo.Driver;

import java.util.List;

public class driverService {
    private driverDaoImpl driverService=new driverDaoImpl();
    public List<Driver> showAllDriver(){return driverService.showAllDriver();}
    public List<Driver> showDriver(int id){return driverService.showDriver(id);}
    public boolean addOneDriver(Driver driver){return driverService.addOneDriver(driver);}
    public boolean deleteDriver(int id){return driverService.deleteOneDriver(id);}
}
