package dao.driverDao;

import vo.driverVo.Pick;

import java.util.List;

public interface PickDao {
    public List<Pick> findsingle(int id);
    public List<Pick> findcrowded(int id);
    public List<Pick> findother(int id);
    public void updatestatus(List<Pick> picks,int id);
    public void driverconfirm(List<Pick> picks);
    public List<Pick> findPassConfirm(int id);
}
