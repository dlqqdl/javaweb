package dao.confereeDao;

import vo.confereeVo.Driver;
import vo.confereeVo.User;

public interface DriverDao {

    /**
     * 查询用户司机信息
     * @param user
     * @return
     */
    public Driver queryDriver(User user);
}
