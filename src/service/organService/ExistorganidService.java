package service.organService;


import dao.organDao.impl.OrganDaoImpl;

public class ExistorganidService {
    public boolean existOrganId(int id){
        OrganDaoImpl organDao=new OrganDaoImpl();
        return organDao.existOrganId(id);
    }
}
