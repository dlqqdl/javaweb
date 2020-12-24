package service.organService;


import dao.organDao.impl.ConfereeDaoImpl;
import vo.organVo.DriverPick;

import java.util.List;

/**
 * @Author ExilePluto
 * @Date 2020/12/22
 */
public class ConfereeServiceImpl implements ConfereeService{
    @Override
    public List<DriverPick> driverPick(int flag,int organID) {
        ConfereeDaoImpl cd=new ConfereeDaoImpl();
        List<DriverPick> driverPicks = cd.unConferee(flag,organID);
        return driverPicks;
    }
}
