package dao.organDao;

public interface OrganDao {
    boolean existOrganId(int id);
    boolean modifyPassword(int id,String password);
}
