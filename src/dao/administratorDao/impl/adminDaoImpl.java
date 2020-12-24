package dao.administratorDao.impl;

import util.JDBCUtil;
import dao.administratorDao.adminDao;
import vo.administratorVo.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class adminDaoImpl implements adminDao {
    @Override
    public Admin addNewAdministrator(Admin admin) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs=null;
        boolean flag=false;
        try {
            connection = JDBCUtil.getConnection();//获取链接
            preparedStatement = connection.prepareStatement("select * from admin where admin_id=?");
            preparedStatement.setInt(1,admin.getAdmin_id());
            rs = preparedStatement.executeQuery();
            if(!rs.next()) {//数据库没有该记录
                preparedStatement = connection.prepareStatement("insert into admin(admin_id,admin_name,telephone,password) value(?,?,?,?)");
                preparedStatement.setInt(1, admin.getAdmin_id());
                preparedStatement.setString(2, admin.getAdmin_name());
                preparedStatement.setInt(3, admin.getTelephone());
                preparedStatement.setString(4, admin.getPassword());
                int i = preparedStatement.executeUpdate();
                if (i > 0)
                    flag = true;//加入成功
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.closeConnection(connection);
        }
        if(flag)
            return admin;
        else
            return null;
    }


    @Override
    public boolean deleteOneAdministrator(Admin admin) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        boolean flag=false;
        try {
            connection = JDBCUtil.getConnection();//获取链接
            preparedStatement = connection.prepareStatement("select * from admin where admin_id=? and password=?");
            preparedStatement.setInt(1,admin.getAdmin_id());
            preparedStatement.setString(2,admin.getPassword());
            rs = preparedStatement.executeQuery();
            if(rs.next()) {//找到数据库有该记录,删除它
                preparedStatement=connection.prepareStatement("delete from admin where admin =? and password=?");
                preparedStatement.setInt(1,admin.getAdmin_id());
                preparedStatement.setString(2,admin.getPassword());
                int i=preparedStatement.executeUpdate();
                if(i>0)
                    flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.closeConnection(connection);
        }
        return flag;
    }

    @Override
    public Admin checkIsAdministrator(Admin admin) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        boolean flag=false;
        try {
            connection = JDBCUtil.getConnection();//获取链接
            preparedStatement = connection.prepareStatement("select * from java.admin where admin_id=? and password=?");
            preparedStatement.setInt(1,admin.getAdmin_id());
            preparedStatement.setString(2,admin.getPassword());
            rs = preparedStatement.executeQuery();
            if(rs.next()){//找到数据库有该记录
                admin.setAdmin_name(rs.getString("admin_name"));
                admin.setTelephone(rs.getInt("telephone"));
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.closeConnection(connection);
        }
        if(flag)
            return admin;
        else
            return null;
    }
    @Override
    public boolean modifyPassword(Admin admin) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        boolean flag=false;
        try{
            connection=JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement("update admin set password=? where admin_id=?");
            preparedStatement.setString(1,admin.getPassword());
            preparedStatement.setInt(2,admin.getAdmin_id());
            int i=preparedStatement.executeUpdate();
            if(i>0)
                flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(connection);
        }
        return flag;
    }

    @Override
    public List<Admin> showAllAdmin() {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        List<Admin> adminList=new ArrayList<>();
        try{
            connection=JDBCUtil.getConnection();
            statement=connection.createStatement();
            rs=statement.executeQuery("select * from admin");
            while(rs.next()){
                adminList.add(new Admin(rs.getInt("admin_id"),rs.getString("admin_name")
                        ,rs.getInt("telephone")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(connection);
        }
        return adminList;
    }
    @Override
    public List<Admin> showAdmin(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Admin> admin=new ArrayList<>();
        try{
            connection=JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement("select * from admin where admin_id=?");
            preparedStatement.setInt(1,id);
            rs=preparedStatement.executeQuery();
            while(rs.next()){
                admin.add(new Admin(rs.getInt("admin_id"),rs.getString("admin_name")
                        ,rs.getInt("telephone")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(connection);
        }
        return admin;
    }
}
