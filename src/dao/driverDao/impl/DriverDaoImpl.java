package dao.driverDao.impl;

import dao.driverDao.DriverDao;
import util.JDBCUtil;
import vo.driverVo.Driver;
import java.sql.*;

public class DriverDaoImpl implements DriverDao {

    @Override
    public int getDriver(int id, String pwd) {
        int i=0;
        Connection con= JDBCUtil.getConnection();
        Driver driver=new Driver();
        try{
            Statement statement=con.createStatement();
            String sql="select * from driver where driver_id='"+id+"'";
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
                driver.setDriver_id(rs.getInt("driver_id"));
                driver.setTelephone(rs.getInt("telephone"));
                driver.setPassword(rs.getString("password"));
                driver.setName(rs.getString("name"));
            }
            if(id==driver.getDriver_id()&&pwd.equals(driver.getPassword()))
                return 1;
        }catch(SQLException  se){
            se.printStackTrace() ;
        }
        return 0;
    }

    @Override
    public Driver findDriver(int id) {
        Connection con = JDBCUtil.getConnection();
        Driver driver=new Driver();
        try{
            Statement statement=con.createStatement();
            String sql="select * from driver where driver_id='"+id+"'";
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
                driver.setDriver_id(rs.getInt("driver_id"));
                driver.setTelephone(rs.getInt("telephone"));
                driver.setPassword(rs.getString("password"));
                driver.setName(rs.getString("name"));
            }
        }catch(SQLException se){
            se.printStackTrace() ;
        }
        return driver;
    }

    @Override
    public int changePwd(int id, String pwd) {
        Connection con = JDBCUtil.getConnection();
        int i=0;
        try{
            Statement statement=con.createStatement();
            String sql;
            sql="update driver set password='"+pwd+"' where driver_id="+id;
            i=statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int Signup(int id, int tel, String name, String pwd) {
        int i=0;
        Connection con = JDBCUtil.getConnection();
        try{
            Statement statement=con.createStatement();
            String sql;
            sql="insert into driver(driver_id,telephone,name,password) values('"+id+"','"+tel+"','"+name+"','"+pwd+"')";
            i=statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    @Override
    public int setStatus(int id, int status) {
        int i=0;
        Connection con = JDBCUtil.getConnection();
        try{
            Statement statement=con.createStatement();
            String sql;
            sql="update driver set dflag='"+status+"' where driver_id="+id;
            i=statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }
}
