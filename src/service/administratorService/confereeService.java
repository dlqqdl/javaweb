package service.administratorService;

import dao.administratorDao.impl.confereeDaoImpl;
import vo.administratorVo.Conferee;

import java.util.List;

public class confereeService {
    private confereeDaoImpl confereeService=new confereeDaoImpl();
    public List<Conferee> showAllUsers(){return confereeService.showAllUser();}
    public List<Conferee> showUser(int id){return confereeService.showUser(id);}
    public boolean deleteUser(int id){return confereeService.deleteUser(id);}
}
