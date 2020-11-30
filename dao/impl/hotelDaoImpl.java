package dao.impl;

import dao.JDBCUtil;
import dao.hotelDao;
import vo.Conferee;
import vo.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class hotelDaoImpl implements hotelDao {

    @Override
    public boolean deleteOneHotel(Hotel hotel) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        boolean flag=false;
        try{
            connection= JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement("select * from hotel where hotel_id=?");
            preparedStatement.setInt(1,hotel.getHotel_id());
            rs=preparedStatement.executeQuery();
            if(rs.next()){
                preparedStatement=connection.prepareStatement("delete from hotel where hotel_id=?");
                preparedStatement.setInt(1,hotel.getHotel_id());
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
                preparedStatement=connection.prepareStatement("insert into hotel(hotel_id,name,address,tel,rooms) value(?,?,?,?,?)");
                preparedStatement.setInt(1,hotel.getHotel_id());
                preparedStatement.setString(2,hotel.getHotel_name());
                preparedStatement.setString(3,hotel.getAddress());
                preparedStatement.setInt(4,hotel.getTel());
                preparedStatement.setInt(5,hotel.getRooms());
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
                        rs.getString("address"),rs.getInt("tel"),rs.getInt("rooms")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(connection);
        }
        return hotelList;
    }
}
