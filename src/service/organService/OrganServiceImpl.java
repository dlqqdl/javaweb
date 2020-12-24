package service.organService;

import dao.organDao.impl.OrganDaoImpl;

public class OrganServiceImpl implements OrganService{
    @Override
    public boolean modifyPassword(int id, String password) {
        OrganDaoImpl organDao=new OrganDaoImpl();
        boolean b = organDao.modifyPassword(id, password);
        return b;
    }
}
