package dao.organDao;


import vo.organVo.DriverPick;

import java.util.List;

public interface ConfereeDao {
    List<DriverPick> unConferee(int i,int organID);
}
