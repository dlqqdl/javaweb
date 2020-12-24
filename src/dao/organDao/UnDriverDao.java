package dao.organDao;


import vo.organVo.Driver;

import java.util.List;

public interface UnDriverDao {

    List<Driver> undriver(int i);


    int changeDriverstate(int did);
}
