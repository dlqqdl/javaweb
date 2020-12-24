package service.administratorService;

import dao.administratorDao.impl.adminDaoImpl;
import vo.administratorVo.Admin;

import java.util.List;

public class adminService {
    private adminDaoImpl service=new adminDaoImpl();
    public Admin checkIsAdministrator(Admin admin){return service.checkIsAdministrator(admin);}
    public Admin addNewAdministrator(Admin admin){return service.addNewAdministrator(admin);}
    public boolean modifyPassword(Admin admin){return service.modifyPassword(admin);}
    public List<Admin> showAllAdmin(){return service.showAllAdmin();}
    public List<Admin> showAdmin(int id){return service.showAdmin(id);}
}
