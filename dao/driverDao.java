package dao;

import vo.Driver;

import java.util.List;

public interface driverDao {
    /**
     * 解约一个司机
     * @param driver
     * @return
     */
    public boolean deleteOneDriver(Driver driver);

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
}
