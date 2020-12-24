package dao.organDao.impl;

import dao.organDao.UnDriverDao;
import util.ConnectionFactory;
import vo.organVo.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ExilePluto
 * @Date 2020/12/21
 */
public class UnDriverDaoImpl implements UnDriverDao {
    @Override
    public List<Driver> undriver(int flag) {
        List<Driver> list=new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        String sql="SELECT driver_id,telephone,name FROM driver WHERE dflag=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,flag);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                int driver_id = resultSet.getInt("driver_id");
                int telepnohe = resultSet.getInt("telephone");
                Driver driver = new Driver(driver_id, telepnohe, name);
                list.add(driver);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public int changeDriverstate(int did) {
        int i=0;
        Connection connection = ConnectionFactory.getConnection();
        String sql="UPDATE driver set dflag=1 WHERE driver_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,did);
             i= statement.executeUpdate();
            if(i==1){
                System.out.println("changeDriverstate1");
            }else {
                System.out.println("changeDriverstate0");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }
}
