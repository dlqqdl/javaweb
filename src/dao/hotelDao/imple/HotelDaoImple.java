package dao.hotelDao.imple;

import dao.hotelDao.HotelDao;
import util.JDBCUtilHotel;
import vo.hotelVo.Hotel;
import vo.hotelVo.Living;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Timgreat
 * @date 2020/11/23 - 22:15
 */
public class HotelDaoImple implements HotelDao {
    //得到当前登录用户
    public Hotel getLoginHotel(Connection connection,String name){
        PreparedStatement pstm=null;
        ResultSet rs=null;
        Hotel hotel=null;

        if(connection!=null){
            String sql="select * from hotel where name=?";
            Object[] params={name};
            try{
                rs=JDBCUtilHotel.execute(connection,pstm,rs,sql,params);
                if(rs.next()){
                    hotel=new Hotel();
                    hotel.setHotelId(rs.getInt("hotel_id"));
                    hotel.setName(rs.getString("name"));
                    hotel.setAddress(rs.getString("address"));
                    hotel.setTel(rs.getInt("tel"));
                    hotel.setRooms(rs.getInt("rooms"));
                    hotel.setPassword(rs.getString("password"));
                    JDBCUtilHotel.closeConnection(null,pstm,rs);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return hotel;
    }
    //修改当前用户密码
    @Override
    public int updatePwd(Connection connection, int hotel_id, String password) {
        PreparedStatement pstm=null;
        int excute=0;
        if(connection!=null){
            String sql="update hotel  set password=? where hotel_id=?";
            Object[] params={password,hotel_id};
            try{
                excute=JDBCUtilHotel.execute(connection,pstm,sql,params);
                JDBCUtilHotel.closeConnection(null,pstm,null);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return excute;
    }

    //获取查询记录数
    @Override
    public int getLivingCount(Connection connection, String name,int hotel_id,int flag) {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        int livingCount=0;
        if(connection!=null){
            StringBuffer sql=new StringBuffer();
            sql.append("select count(1) as count\n" +
                    "from living l,conferee c\n" +
                    "where c.conf_id=l.conf_id and flag=?");
            List<Object> list=new ArrayList<Object>();
            list.add(flag);
            if(name!=null&&!name.equals("")){
                sql.append(" and c.name like ?");
                list.add("%"+name+"%");
            }
            if(hotel_id>0){
                sql.append(" and l.hotel_id = ?");
                list.add(hotel_id);
            }
            Object[] params= list.toArray();
            try{
                rs=JDBCUtilHotel.execute(connection,pstm,rs,sql.toString(),params);
                if(rs.next()){
                    livingCount=rs.getInt("count");
                }
                JDBCUtilHotel.closeConnection(null,pstm,rs);
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return livingCount;
    }
    //显示查询结果
    @Override
    public List<Living> getLivingList(Connection connection, String name, int hotel_id, int currentPage, int pageSize,int flag) {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List<Living> livingList=new ArrayList<>();
        if(connection!=null){
            StringBuffer sql=new StringBuffer();
            sql.append("select c.conf_id id,name,sex,tel,room_id,starttime,endtime,c.description request,l.description response" +
                    " from conferee c, living l" +
                    " where c.conf_id=l.conf_id and flag=?");
            List<Object> list=new ArrayList<>();
            list.add(flag);
            if(name!=null&&!name.equals("")){
                sql.append(" and c.name like ?");
                list.add("%"+name+"%");
            }
            if(hotel_id>0){
                sql.append(" and l.hotel_id = ?");
                list.add(hotel_id);
            }
            //分页操作

            sql.append(" order by id limit ?,?");
            currentPage=(currentPage-1)*pageSize;
            list.add(currentPage);
            list.add(pageSize);
            Object[] params= list.toArray();
            try{
                rs=JDBCUtilHotel.execute(connection,pstm,rs, sql.toString(), params);
                while(rs.next()){
                    Living living=new Living();
                    living.setConfId(rs.getInt("id"));
                    living.setConfereeName(rs.getString("name"));
                    living.setSex(rs.getString("sex"));
                    living.setRoomId(rs.getInt("room_id"));
                    living.setTel(rs.getInt("tel"));
                    living.setStartTime(rs.getDate("starttime"));
                    living.setEndTime(rs.getDate("endtime"));
                    living.setRequest(rs.getString("request"));
                    living.setResponse(rs.getString("response"));
                    living.setFlag(flag);
                    livingList.add(living);
                }
                JDBCUtilHotel.closeConnection(null,pstm,rs);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return livingList;
    }
    //增加住宿记录
    @Override
    public int addLiving(Connection connection, Living living) {
        PreparedStatement pstm=null;
        int add=0;
        if(connection!=null){
            try{
                String sql="insert into living (hotel_id,room_id,conf_id,starttime,endtime,description,flag) values(?,?,?,?,?,?,1)";
                Object[] params1={living.getHotelId(),living.getRoomId(),living.getConfId(),living.getStartTime(),living.getEndTime(),living.getRequest()};
                add=JDBCUtilHotel.execute(connection,pstm,sql,params1);
                Object[] params2={living.getHotelId()};
                sql="update hotel set rooms=rooms-1 where hotel_id=?";
                JDBCUtilHotel.execute(connection,pstm,sql,params2);
                JDBCUtilHotel.closeConnection(null,pstm,null);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return add;
    }
    //判断住宿记录是否已存在 如果存在，拒绝添加
    @Override
    public boolean idExist(Connection connection, int conf_id)  {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        boolean flag=false;
        if(connection!=null){
            try{
                String sql="select hotel_id from living where flag=1 and conf_id=?";
                Object[] params={conf_id};
                rs=JDBCUtilHotel.execute(connection,pstm,rs,sql,params);
                if(rs.next())
                    flag=true;
                JDBCUtilHotel.closeConnection(null,pstm,rs);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return flag;
    }
    //删除住宿记录
    @Override
    public int deleteLiving(Connection connection, int conf_id,int hotel_id,int flag) {
        PreparedStatement pstm=null;
        int delete=0;
        if(connection!=null){
            try{
                String sql=" delete from living where conf_id=?";
                Object[] params={conf_id};
                delete=JDBCUtilHotel.execute(connection,pstm,sql,params);
                if(flag==1){
                    sql=" update hotel set rooms=rooms+1 where hotel_id=?";
                    Object[] params2={hotel_id};
                    JDBCUtilHotel.execute(connection,pstm,sql,params2);
                }
                JDBCUtilHotel.closeConnection(null,pstm,null);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return delete;
    }
    //修改住宿记录
    @Override
    public int modifyLiving(Connection connection, Living living) {
        PreparedStatement pstm=null;
        int modify=0;
        if(connection!=null){
            try{
                String sql="update living set flag=1,room_id=?,starttime=?,endtime=?,description=? where conf_id=?";
                Object[] params={living.getRoomId(),living.getStartTime(),living.getEndTime(),living.getResponse(),living.getConfId()};
                modify=JDBCUtilHotel.execute(connection,pstm,sql,params);
                if(living.getFlag()==0){
                    sql=" update hotel set rooms=rooms-1 where hotel_id=?";
                    Object[] params2={living.getHotelId()};
                    JDBCUtilHotel.execute(connection,pstm,sql,params2);
                }
                JDBCUtilHotel.closeConnection(null,pstm,null);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return modify;
    }
    //查看具体住宿信息
    @Override
    public Living viewLiving(Connection connection, int conf_id) {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        Living living=null;
        if(connection!=null){
            String sql="select c.conf_id id,name,sex,tel,room_id,starttime,endtime,c.description request,l.description response"+
                    " from living l,conferee c where l.conf_id=c.conf_id and l.conf_id=?";
            Object[] params={conf_id};
            try{
                rs=JDBCUtilHotel.execute(connection,pstm,rs,sql,params);
                if(rs.next()){
                    living=new Living();
                    living.setConfId(rs.getInt("id"));
                    living.setConfereeName(rs.getString("name"));
                    living.setSex(rs.getString("sex"));
                    living.setRoomId(rs.getInt("room_id"));
                    living.setTel(rs.getInt("tel"));
                    living.setStartTime(rs.getDate("starttime"));
                    living.setEndTime(rs.getDate("endtime"));
                    living.setRequest(rs.getString("request"));
                    living.setResponse(rs.getString("response"));
                }
                JDBCUtilHotel.closeConnection(null,pstm,rs);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return living;
    }
    //得到剩余房间数
    @Override
    public int getNumOfRoom(Connection connection, int hotel_id) {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        int numOfRoom=0;
        if(connection!=null){
            String sql="select rooms from hotel where hotel_id=?";
            Object[] params={hotel_id};
            try{
                rs=JDBCUtilHotel.execute(connection,pstm,rs,sql,params);
                if(rs.next()){
                    numOfRoom=rs.getInt("rooms");
                }
                JDBCUtilHotel.closeConnection(null,pstm,rs);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return numOfRoom;
    }

}
