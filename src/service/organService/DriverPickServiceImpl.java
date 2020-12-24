package service.organService;


import dao.organDao.DriverPickDao;
import dao.organDao.impl.DriverPickDaoImpl;

/**
 * @Author ExilePluto
 * @Date 2020/12/22
 */
public class DriverPickServiceImpl implements DriverPickService{
    @Override
    public int insertDriver(int did, int cid) {
        DriverPickDao dpd=new DriverPickDaoImpl();
        int i = dpd.insertDriver(did, cid);
        return i;
    }
}
