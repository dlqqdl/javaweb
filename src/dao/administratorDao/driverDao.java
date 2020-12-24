package dao.administratorDao;

import vo.administratorVo.Driver;

import java.util.List;

public interface driverDao {
    /**
     * 解约一个司机
     * @param
     * @return
     */
    public boolean deleteOneDriver(int id);

    /**
     * 雇佣一个司机
     * @param driver
     * @return
     */
    public boolean addOneDriver(Driver driver);

    /**
     * 查看所有雇佣司机
     * @return
     */
    public List<Driver> showAllDriver();
    public List<Driver> showDriver(int id);
}
