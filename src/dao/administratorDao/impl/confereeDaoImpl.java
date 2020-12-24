package dao.administratorDao.impl;

import util.JDBCUtil;
import dao.administratorDao.confereeDao;
import vo.administratorVo.Conferee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class confereeDaoImpl implements confereeDao {
    @Override
    public boolean addAUser(Conferee conferee) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        boolean flag=false;
        try {
            connection = JDBCUtil.getConnection();//获取链接
            preparedStatement = connection.prepareStatement("select * from conferee where conf_id=? and account=?");
            preparedStatement.setInt(1,conferee.getConf_id());
            preparedStatement.setInt(2,conferee.getAccount());
            rs = preparedStatement.executeQuery();
            if(!rs.next()) {
                preparedStatement=connection.prepareStatement("insert into conferee(conf_id,name,account,password,tel,sex,email," +
                        "description) value(?,?,?,?,?,?,?,?)");
                preparedStatement.setInt(1,conferee.getConf_id());
                preparedStatement.setString(2,conferee.getConf_name());
                preparedStatement.setInt(3,conferee.getAccount());
                preparedStatement.setString(4,conferee.getPassword());
                preparedStatement.setInt(5,conferee.getTel());
                preparedStatement.setString(6,conferee.getSex());
                preparedStatement.setString(7,conferee.getEmail());
                preparedStatement.setString(8,conferee.getDescription());
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
    public boolean deleteUser(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean flag=false;
        try {
            connection = JDBCUtil.getConnection();//获取链接
            preparedStatement = connection.prepareStatement("delete from conferee where conf_id=?");
            preparedStatement.setInt(1, id);
            int i=preparedStatement.executeUpdate();
            if (i>0)
                flag=true;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.closeConnection(connection);
        }
        return flag;
    }

    @Override
    public boolean upGradeToOrganizer(Conferee conferee) {
        return false;
    }

    @Override
    public List<Conferee> showAllUser() {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        List<Conferee> userList=new ArrayList<>();
        try{
            connection=JDBCUtil.getConnection();
            statement=connection.createStatement();
            rs=statement.executeQuery("select * from conferee");
            while(rs.next()){
                userList.add(new Conferee(rs.getInt("conf_id"),rs.getString("name"),
                        rs.getInt("account"),rs.getString("password"),rs.getInt("tel"),
                        rs.getString("sex"),rs.getString("email")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(connection);
        }
        return userList;
    }

    @Override
    public List<Conferee> showUser(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet rs = null;
        List<Conferee> userList=new ArrayList<>();
        try{
            connection=JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement("select * from conferee where conf_id=?");
            preparedStatement.setInt(1,id);
            rs=preparedStatement.executeQuery();
            while(rs.next()){
                userList.add(new Conferee(rs.getInt("conf_id"),rs.getString("name"),
                        rs.getInt("account"),rs.getString("password"),rs.getInt("tel"),
                        rs.getString("sex"),rs.getString("email")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(connection);
        }
        return userList;
    }
}
