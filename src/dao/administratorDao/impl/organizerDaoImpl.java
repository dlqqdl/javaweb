package dao.administratorDao.impl;

import util.JDBCUtil;
import dao.administratorDao.organizerDao;
import vo.administratorVo.Organizer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class organizerDaoImpl implements organizerDao {
    @Override
    public boolean deleteOrganizer(int id) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        boolean flag=false;
        try{
            connection=JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement("select * from organ where organ_id=?");
            preparedStatement.setInt(1,id);
            rs=preparedStatement.executeQuery();
            if(rs.next()){
                preparedStatement=connection.prepareStatement("delete from organ where organ_id=?");
                preparedStatement.setInt(1,id);
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
    public boolean addOneOrganizer(Organizer organizer) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        boolean flag=false;
        try{
            connection=JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement("select * from organ where organ_id=?");
            preparedStatement.setInt(1,organizer.getOrgan_id());
            rs=preparedStatement.executeQuery();
            if(!rs.next()){
                preparedStatement=connection.prepareStatement("insert into organ(organ_id,org_name,telephone,password) value(?,?,?,?)");
                preparedStatement.setInt(1,organizer.getOrgan_id());
                preparedStatement.setString(2,organizer.getOrgan_name());
                preparedStatement.setInt(3,organizer.getTelephone());
                preparedStatement.setString(4,organizer.getPassword());
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
    public List<Organizer> showAllOrganizer() {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        List<Organizer> organList=new ArrayList<>();
        try{
            connection=JDBCUtil.getConnection();
            statement=connection.createStatement();
            rs=statement.executeQuery("select * from organ");
            while(rs.next()){
                organList.add(new Organizer(rs.getInt("organ_id"),rs.getString("org_name"),
                        rs.getInt("telephone"),rs.getString("password")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(connection);
        }
        return organList;
    }

    @Override
    public List<Organizer> showOrganizer(int id) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        List<Organizer> organList=new ArrayList<>();
        try{
            connection=JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement("select * from organ where organ_id=?");
            preparedStatement.setInt(1,id);
            rs=preparedStatement.executeQuery();
            if(rs.next()){
                organList.add(new Organizer(rs.getInt("organ_id"),rs.getString("org_name"),
                        rs.getInt("telephone"),rs.getString("password")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(connection);
        }
        return organList;
    }
}
