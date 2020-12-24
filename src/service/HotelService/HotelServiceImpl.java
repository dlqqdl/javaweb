package service.HotelService;

import dao.hotelDao.HotelDao;
import dao.hotelDao.imple.HotelDaoImple;
import service.HotelService.HotelService;
import util.JDBCUtilHotel;
import vo.hotelVo.Hotel;
import vo.hotelVo.Living;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author Timgreat
 * @date 2020/12/5 - 11:19
 */
public class HotelServiceImpl implements HotelService {

    private HotelDao hotelDao;

    public HotelServiceImpl(){
        hotelDao=new HotelDaoImple();
    }

    //登录服务方法
    @Override
    public Hotel login(String name, String password) {
        Connection connection=null;
        Hotel hotel=null;

        connection= JDBCUtilHotel.getConnection();
        hotel=hotelDao.getLoginHotel(connection,name);
        JDBCUtilHotel.closeConnection(connection,null,null);
        if(hotel!=null){
            if(!password.equals(hotel.getPassword()))
                hotel=null;
        }
        return hotel;
    }
    //修改密码服务
    @Override
    public boolean updatePwd(int hotel_id, String password) {
        Connection connection=null;
        boolean flag=false;
        connection=JDBCUtilHotel.getConnection();
        if(hotelDao.updatePwd(connection,hotel_id,password)>0)
            flag=true;
        JDBCUtilHotel.closeConnection(connection,null,null);
        return flag;
    }
    //获取相关记录数
    @Override
    public int getLivingCount(String name, int hotel_id,int flag) {
        Connection connection=JDBCUtilHotel.getConnection();
        int livingCount=0;
        livingCount=hotelDao.getLivingCount(connection,name,hotel_id,flag);
        JDBCUtilHotel.closeConnection(connection,null,null);
        return livingCount;
    }
    //展示住宿者信息
    @Override
    public List<Living> getLivingList(String name, int hotel_id, int currentPage, int pageSize,int flag) {
        Connection connection=null;
        List<Living> livingList=null;

        connection=JDBCUtilHotel.getConnection();
        livingList=hotelDao.getLivingList(connection,name,hotel_id,currentPage,pageSize,flag);
        JDBCUtilHotel.closeConnection(connection,null,null);
        return livingList;
    }
    //添加住宿者
    @Override
    public boolean addLiving(Living living) {
        Connection connection=null;
        boolean flag=false;
        try{
            connection=JDBCUtilHotel.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            int  result= hotelDao.addLiving(connection,living);
            connection.commit();
            if(result > 0){
                flag = true;
                System.out.println("add success!");
            }else{
                System.out.println("add failed!");
            }
        }catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally{
            JDBCUtilHotel.closeConnection(connection,null,null);
        }
        return flag;
    }
    //判断住宿记录是否已存在
    @Override
    public boolean isExist(int conf_id) {
        Connection connection=null;
        connection=JDBCUtilHotel.getConnection();
        boolean flag=false;
        flag=hotelDao.idExist(connection,conf_id);
        JDBCUtilHotel.closeConnection(connection,null,null);
        return flag;
    }
    //删除住宿记录
    @Override
    public boolean deleteLiving(int conf_id,int hotel_id,int sign) {
        Connection connection=null;
        boolean flag=false;
        try{
            connection=JDBCUtilHotel.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            int  result= hotelDao.deleteLiving(connection,conf_id,hotel_id,sign);
            connection.commit();
            if(result > 0){
                flag = true;
                System.out.println("delete success!");
            }else{
                System.out.println("delete failed!");
            }
        }catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally{
            JDBCUtilHotel.closeConnection(connection,null,null);
        }
        return flag;
    }
    //修改住宿记录
    @Override
    public boolean modifyLiving(Living living) {
        Connection connection=null;
        boolean flag=false;
        try{
            connection=JDBCUtilHotel.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            int  result= hotelDao.modifyLiving(connection,living);
            connection.commit();
            if(result > 0){
                flag = true;
                System.out.println("modify success!");
            }else{
                System.out.println("modify failed!");
            }
        }catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally{
            JDBCUtilHotel.closeConnection(connection,null,null);
        }
        return flag;
    }
    //查看住宿记录
    @Override
    public Living viewLiving(int conf_id) {
        Connection connection=null;
        Living living=null;
        connection=JDBCUtilHotel.getConnection();
        living=hotelDao.viewLiving(connection,conf_id);
        JDBCUtilHotel.closeConnection(connection,null,null);
        return living;
    }
    //获得房间数
    @Override
    public int getNumOfRoom(int hotel_id) {
        Connection connection=null;
        connection=JDBCUtilHotel.getConnection();
        int numOfRoom=0;
        numOfRoom=hotelDao.getNumOfRoom(connection,hotel_id);
        JDBCUtilHotel.closeConnection(connection,null,null);
        return numOfRoom;
    }

}
