package service.confereeService;

import vo.confereeVo.Driver;
import vo.confereeVo.User;

public interface DriverService {
    /**
     * 查找用户的司机
     * @param user
     * @return
     */
    public Driver getDriver(User user);
}
