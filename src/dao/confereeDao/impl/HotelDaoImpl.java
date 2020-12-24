package dao.confereeDao.impl;

import dao.confereeDao.HotelDao;
import util.JDBCUtil;
import vo.confereeVo.Hotel;
import vo.confereeVo.Meeting;
import vo.confereeVo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class HotelDaoImpl implements HotelDao {

    @Override
    public Hotel QueryAllHotelsByUserAndPassword(User user) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        int conf_id=user.getConf_id();
        System.out.println("conf_id="+conf_id);
        Hotel hotel =new Hotel();
        try {
            connection = JDBCUtil.getConnection();
            String sql= "select hotel.*,living.* from hotel,living,conferee\n" +
                    "where hotel.hotel_id=living.hotel_id and living.conf_id=conferee.conf_id and conferee.conf_id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,conf_id);
            rs=preparedStatement.executeQuery();

            while (rs.next()){

                hotel.setStarttime(rs.getDate("living.starttime"));
                hotel.setEndtime(rs.getDate("living.endtime"));
                hotel.setFlag(rs.getBoolean("living.flag"));
                hotel.setHotel_id(rs.getInt("hotel.hotel_id"));
                hotel.setName(rs.getString("hotel.name"));
                hotel.setAddress(rs.getString("hotel.address"));
                hotel.setTel(rs.getInt("hotel.tel"));
                hotel.setRoom_id(rs.getInt("living.room_id"));
                hotel.setConf_id(rs.getInt("living.conf_id"));
                hotel.setDescription(rs.getString("living.description"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        if (hotel==null)
            System.out.println("hotel为空！！");
        return hotel;

    }

    @Override
    public List<Hotel> ShowAllHotels() {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        try {
            connection = JDBCUtil.getConnection();
            String sql= "select hotel.* from hotel";
//            String sql= "select living.*,hotel.* from living,hotel where hotel.hotel_id=living.hotel_id";
            preparedStatement=connection.prepareStatement(sql);
            rs=preparedStatement.executeQuery();
            List<Hotel> hotelList=new LinkedList<>();

            while (rs.next()) {
                Hotel hotel=new Hotel();

                hotel.setName(rs.getString("hotel.name"));
                hotel.setAddress(rs.getString("hotel.address"));
                hotel.setTel(rs.getInt("hotel.tel"));
                hotel.setRooms(rs.getInt("hotel.rooms"));
                hotel.setHotel_id(rs.getInt("hotel.hotel_id"));
//                hotel.setRoom_id(rs.getInt("living.room_id"));
//                hotel.setDescription(rs.getString("living.description"));
//                hotel.setFlag(rs.getBoolean("living.flag"));
//                hotel.setStarttime(rs.getDate("living.starttime"));
//                hotel.setEndtime(rs.getDate("living.endtime"));
                hotelList.add(hotel);
            }
            return hotelList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return null;
    }

    @Override
    public Hotel GetHotel(int hotelId) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        Hotel hotel=new Hotel();

//        System.out.println("hotelId=!!"+hotelId);

        try {
            connection = JDBCUtil.getConnection();
            String sql= "select * from hotel where hotel.hotel_id=?";
//            String sql= "select living.*,hotel.* from living,hotel where hotel.hotel_id=living.hotel_id and hotel.hotel_id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,hotelId);
            rs=preparedStatement.executeQuery();
            while (rs.next()) {
                hotel.setHotel_id(rs.getInt("hotel.hotel_id"));
                hotel.setName(rs.getString("hotel.name"));
                hotel.setAddress(rs.getString("hotel.address"));
                hotel.setTel(rs.getInt("hotel.tel"));
                hotel.setRooms(rs.getInt("hotel.rooms"));
//                hotel.setRoom_id(rs.getInt("living.room_id"));
//                hotel.setDescription(rs.getString("living.description"));
//                hotel.setFlag(rs.getBoolean("living.flag"));
//                hotel.setStarttime(rs.getDate("living.starttime"));
//                hotel.setEndtime(rs.getDate("living.endtime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return hotel;
    }

    @Override
    public void Insert(Hotel hotel, User user) {
        Connection connection=null;
        ResultSet rs=null;
        int hotel_id=hotel.getHotel_id();
        String description=hotel.getDescription();
        boolean flag=hotel.getFlag();
        Date starttime=hotel.getStarttime();

        Date endtime=hotel.getEndtime();
        int conf_id=user.getConf_id();
        System.out.println("starttime="+starttime+"endtime="+endtime);
        try {
            connection = JDBCUtil.getConnection();
            Statement stat=connection.createStatement();
//            String sql= "insert into living(description,starttime,endtime,room_id,conf_id,hotel_id) values (?,?,?,?,?,?)";
            String sql= "insert into living(hotel_id,room_id,conf_id,description,flag,starttime,endtime) values (?,?,?,?,?,?,?)";
//            String sql= "insert into living(hotel_id,conf_id,description,flag,starttime,endtime,room_id) values (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setInt(1,hotel_id);
            preparedStatement.setInt(2,hotel.getRoom_id());
            preparedStatement.setInt(3,conf_id);
            preparedStatement.setString(4,description);
            preparedStatement.setInt(5, 0);
            preparedStatement.setDate(6, (Date) starttime);
            preparedStatement.setDate(7, (Date) endtime);

            int i=preparedStatement.executeUpdate();
            System.out.println("成功添加"+i+"行");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
    }
}
