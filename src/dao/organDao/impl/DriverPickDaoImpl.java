package dao.organDao.impl;


import dao.organDao.DriverPickDao;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author ExilePluto
 * @Date 2020/12/22
 */
public class DriverPickDaoImpl implements DriverPickDao {
    @Override
    public int insertDriver(int did, int cid) {
        int i=0;
        Connection connection = ConnectionFactory.getConnection();
        String sql="UPDATE pick set driver_id=? WHERE conf_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,did);
            statement.setInt(2,cid);
            i = statement.executeUpdate();
            if(i!=0){
                System.out.println("insertDriver1");
            }else {
                System.out.println("insertDriver0");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }
}
