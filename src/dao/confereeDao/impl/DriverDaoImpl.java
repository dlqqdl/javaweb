package dao.confereeDao.impl;

import dao.confereeDao.DriverDao;
import util.JDBCUtil;
import vo.confereeVo.Driver;
import vo.confereeVo.Hotel;
import vo.confereeVo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver queryDriver(User user) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        int conf_id=user.getConf_id();
        Driver driver=new Driver();
        System.out.println("DriverDao__conf_id="+conf_id);
        try {
            connection = JDBCUtil.getConnection();
            String sql= "select driver.*,pick.* from driver,pick,conferee where driver.driver_id=pick.driver_id and pick.conf_id=conferee.conf_id and conferee.conf_id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,conf_id);
            rs=preparedStatement.executeQuery();

            while (rs.next()){
                System.out.println("yes!!");

                driver.setDirver_id(rs.getInt("driver.driver_id"));
                driver.setTelephone(rs.getInt("driver.telephone"));
                driver.setName(rs.getString("driver.name"));
                driver.setPick_time(rs.getDate("pick.pick_time"));
                driver.setLeave_time(rs.getDate("pick.leave_time"));
                driver.setDescription(rs.getString("pick.description"));


            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        if (driver==null)
            System.out.println("rdetgdsfsdfsfjlsdf");
        return driver;
    }
}
