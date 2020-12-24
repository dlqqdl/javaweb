package dao.administratorDao.impl;

import util.JDBCUtil;
import dao.administratorDao.hotelDao;
import vo.administratorVo.Hotel;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class hotelDaoImpl implements hotelDao {

    @Override
    public boolean deleteOneHotel(int id,String name) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        boolean flag=false;
        try{
            connection= JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement("select * from hotel where hotel_id=? and name=?");
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            rs=preparedStatement.executeQuery();
            if(rs.next()){
                preparedStatement=connection.prepareStatement("delete from hotel where hotel_id=? and name=?");
                preparedStatement.setInt(1,id);
                preparedStatement.setString(2,name);
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
    public boolean addOneHotel(Hotel hotel) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        boolean flag=false;
        try{
            connection= JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement("select * from hotel where hotel_id=?");
            preparedStatement.setInt(1,hotel.getHotel_id());
            rs=preparedStatement.executeQuery();
            if(!rs.next()){
                preparedStatement=connection.prepareStatement("insert into hotel(hotel_id,name,address,tel,rooms,password) value(?,?,?,?,?,?)");
                preparedStatement.setInt(1,hotel.getHotel_id());
                preparedStatement.setString(2,hotel.getHotel_name());
                preparedStatement.setString(3,hotel.getAddress());
                preparedStatement.setInt(4,hotel.getTel());
                preparedStatement.setInt(5,hotel.getRooms());
                preparedStatement.setString(6,hotel.getPassword());
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
    public List<Hotel> showAllHotel() {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        List<Hotel> hotelList=new ArrayList<>();
        try{
            connection=JDBCUtil.getConnection();
            statement=connection.createStatement();
            rs=statement.executeQuery("select * from hotel");
            while(rs.next()){
                hotelList.add(new Hotel(rs.getInt("hotel_id"),rs.getString("name"),
                        rs.getString("address"),rs.getInt("tel"),
                        rs.getInt("rooms"),rs.getString("password")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(connection);
        }
        return hotelList;
    }

    @Override
    public List<Hotel> searchHotel(String hotelName) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet rs = null;
        List<Hotel> hotelList=new ArrayList<>();
        try{
            connection=JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement("select * from hotel where name=?");
            preparedStatement.setString(1,hotelName);
            rs=preparedStatement.executeQuery();
            while(rs.next()){
                hotelList.add(new Hotel(rs.getInt("hotel_id"),rs.getString("name"),
                        rs.getString("address"),rs.getInt("tel"),
                        rs.getInt("rooms"),rs.getString("password")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(connection);
        }
        return hotelList;
    }
}
