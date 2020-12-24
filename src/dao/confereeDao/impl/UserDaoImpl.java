package dao.confereeDao.impl;

import dao.confereeDao.UserDao;
import util.JDBCUtil;
import vo.confereeVo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        try {
            connection = JDBCUtil.getConnection();
            String sql= "select conf_id,name,account,password,tel,sex,email,description from conferee where name=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            rs=preparedStatement.executeQuery();

            while (rs.next()){
                User user=new User();
                user.setConf_id(rs.getInt("conf_id"));
                user.setName(rs.getString("name"));
                user.setAccount(rs.getInt("account"));
                user.setPassword(rs.getString("password"));
                user.setTel(rs.getInt("tel"));
                user.setSex(rs.getString("sex"));
                user.setEmail(rs.getString("email"));
                user.setDescription(rs.getString("description"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return null;
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        try {
            connection = JDBCUtil.getConnection();
            String sql= "select * from conferee where name=? and password=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            rs=preparedStatement.executeQuery();

            while (rs.next()){
                User user=new User();
                user.setConf_id(rs.getInt("conf_id"));
                user.setName(rs.getString("name"));
                user.setAccount(rs.getInt("account"));
                user.setPassword(rs.getString("password"));
                user.setTel(rs.getInt("tel"));
                user.setSex(rs.getString("sex"));
                user.setEmail(rs.getString("email"));
                user.setDescription(rs.getString("description"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return null;
    }

    @Override
    public User saveUser(User user) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;

//        user.setConf_id(user.getConf_id()+200);

        try {
            connection = JDBCUtil.getConnection();
            String sql= "insert into conferee(conf_id,name,account,password,tel,sex,email,description) values(?,?,?,?,?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,0);
            preparedStatement.setString(2,user.getName());
            preparedStatement.setInt(3,user.getAccount());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setInt(5,user.getTel());
            preparedStatement.setString(6,user.getSex());
            preparedStatement.setString(7,user.getEmail());
            preparedStatement.setString(8,user.getDescription());
//            int i= preparedStatement.executeUpdate(sql);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        try {
            connection = JDBCUtil.getConnection();
            String sql= "update conferee set name=?,account=?,password=?,tel=?,email=?,description=? where conf_id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setInt(2,user.getAccount());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setInt(4,user.getTel());
            preparedStatement.setString(5,user.getEmail());
            preparedStatement.setString(6,user.getDescription());
            preparedStatement.setInt(7,user.getConf_id());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return user;
    }
}
