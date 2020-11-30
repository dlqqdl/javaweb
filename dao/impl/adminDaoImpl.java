package dao.impl;

import dao.JDBCUtil;
import dao.adminDao;
import vo.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminDaoImpl implements adminDao {
    @Override
    public boolean addNewAdministrator(Admin admin) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs=null;
        boolean flag=false;
        try {
            connection = JDBCUtil.getConnection();//获取链接
            preparedStatement = connection.prepareStatement("select * from 'admin' where admin_id=? and password=?");
            preparedStatement.setInt(1,admin.getAdmin_id());
            preparedStatement.setString(2,admin.getPassword());
            rs = preparedStatement.executeQuery();
            if(!rs.next()) {//数据库没有该记录
                preparedStatement = connection.prepareStatement("insert into 'admin(admin_id,admin_name,telephone,password)' value(?,?,?,?)");
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
        return flag;
    }


    @Override
    public boolean deleteOneAdministrator(Admin admin) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        boolean flag=false;
        try {
            connection = JDBCUtil.getConnection();//获取链接
            preparedStatement = connection.prepareStatement("select * from 'admin' where admin_id=? and password=?");
            preparedStatement.setInt(1,admin.getAdmin_id());
            preparedStatement.setString(2,admin.getPassword());
            rs = preparedStatement.executeQuery();
            if(rs.next()) {//找到数据库有该记录,删除它
                preparedStatement=connection.prepareStatement("delete from 'admin' where admin =? and password=?");
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
    public boolean checkIsAdministrator(Admin admin) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        boolean flag=false;
        try {
            connection = JDBCUtil.getConnection();//获取链接
            preparedStatement = connection.prepareStatement("select * from 'admin' where admin_id=? and password=?");
            preparedStatement.setInt(1,admin.getAdmin_id());
            preparedStatement.setString(2,admin.getPassword());
            rs = preparedStatement.executeQuery();
            if(rs.next())
                flag=true;//找到数据库有该记录
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.closeConnection(connection);
        }
        return flag;
    }

    @Override
    public boolean modifyAdminInfo(Admin admin) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        boolean flag=false;
        try{
            connection=JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement("update 'admin' set admin_name=? ,telephone=? ,password=? "+
                    "where admin_i=?");
            preparedStatement.setString(1,admin.getAdmin_name());
            preparedStatement.setInt(2,admin.getTelephone());
            preparedStatement.setString(3,admin.getPassword());
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
}
