package dao.impl;

import dao.JDBCUtil;
import dao.driverDao;
import vo.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class driverDaoImpl implements driverDao {

    @Override
    public boolean deleteOneDriver(Driver driver) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        boolean flag=false;
        try{
            connection= JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement("select * from driver where driver_id=?");
            preparedStatement.setInt(1,driver.getDriver_id());
            rs=preparedStatement.executeQuery();
            if(rs.next()){
                preparedStatement=connection.prepareStatement("delete from driver where driver_id=?");
                preparedStatement.setInt(1,driver.getDriver_id());
                int i=preparedStatement.executeUpdate();
                if(i>0)
                    flag=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(connection);
        }
        return flag;
    }

    @Override
    public boolean addOneDriver(Driver driver) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        boolean flag=false;
        try{
            connection= JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement("select * from driver where driver_id=?");
            preparedStatement.setInt(1,driver.getDriver_id());
            rs=preparedStatement.executeQuery();
            if(!rs.next()){
                preparedStatement=connection.prepareStatement("insert into driver(driver_id,telephone,name,password) value(?.?.?.?)");
                preparedStatement.setInt(1,driver.getDriver_id());
                preparedStatement.setInt(2,driver.getTelephone());
                preparedStatement.setString(3,driver.getName());
                preparedStatement.setString(4,driver.getPassword());
                int i=preparedStatement.executeUpdate();
                if(i>0)
                    flag=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(connection);
        }
        return flag;
    }

    @Override
    public List<Driver> showAllDriver() {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        List<Driver> driverList=new ArrayList<>();
        try{
            connection=JDBCUtil.getConnection();
            statement=connection.createStatement();
            rs=statement.executeQuery("select * from driver");
            while(rs.next()){
                driverList.add(new Driver(rs.getInt("driver_id"),rs.getInt("telephone")
                        ,rs.getString("name"),rs.getString("password")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(connection);
        }
        return driverList;
    }
}
