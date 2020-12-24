package service.organService;



import vo.organVo.Driver;

import java.util.List;

/**
 * @Author ExilePluto
 * @Date 2020/12/21
 */
public interface DriverService {
    List<Driver> unDriver(int flag);

    int changeDriverstate(int did);
}
