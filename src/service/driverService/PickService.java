package service.driverService;

import dao.driverDao.PickDao;
import dao.driverDao.impl.PickDaoImpl;
import vo.driverVo.Pick;

import java.util.List;

public class PickService {
    private PickDao pickDao=new PickDaoImpl();
    public List<Pick> findsingle(int id){return pickDao.findsingle(id);}
    public List<Pick> findcrowded(int id){return pickDao.findcrowded(id);}
    public List<Pick> findother(int id){return pickDao.findother(id);}
    public void updatestatus(List<Pick> picks,int id){pickDao.updatestatus(picks,id);}
    public List<Pick> findPassConfirm(int id){return pickDao.findPassConfirm(id);}
    public void driverconfirm(List<Pick> picks){pickDao.driverconfirm(picks);}
}
