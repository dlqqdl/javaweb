package dao.driverDao.impl;

import dao.driverDao.PickDao;
import util.JDBCUtil;
import vo.driverVo.Driver;
import vo.driverVo.Pick;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PickDaoImpl implements PickDao {

    @Override
    public List<Pick> findsingle(int id) {
        Connection con = JDBCUtil.getConnection();
        List<Pick> picks=new ArrayList<Pick>();
        try{
            Statement statement=con.createStatement();
            String sql="select * from pick where description like '%专车%' and driver_id="+id+" and pick_time is null order by leave_time asc";
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
                Pick pick=new Pick();
                String time;
                pick.setConf_id(rs.getInt("conf_id"));
                time= String.valueOf(rs.getTimestamp("leave_time"));
                time=time.replace(".0","");
                pick.setLeave_time(time);
                pick.setDescription(rs.getString("description"));
                picks.add(pick);
            }
        }catch(SQLException se){
            se.printStackTrace() ;
        }
        return picks;
    }

    @Override
    public List<Pick> findcrowded(int id) {
        Connection con = JDBCUtil.getConnection();
        List<Pick> picks=new ArrayList<Pick>();
        try{
            Statement statement=con.createStatement();
//            conf_id              int not null,
//                    driver_id            int,
//            pick_time            datetime,
//            leave_time           datetime,
//            description          varchar(255),
//                    driver_confirm       tinyint,
//                    conferee_confirm     tinyint,
            String sql="select * from pick where description like '%大巴%' and driver_id="+id+" and pick_time is null order by leave_time asc";
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
                Pick pick=new Pick();
                String time;
                pick.setConf_id(rs.getInt("conf_id"));
                time= String.valueOf(rs.getTimestamp("leave_time"));
                time=time.replace(".0","");
                pick.setLeave_time(time);
                pick.setDescription(rs.getString("description"));
                picks.add(pick);
            }
        }catch(SQLException se){
            se.printStackTrace() ;
        }
        return picks;
    }
    @Override
    public List<Pick> findother(int id) {
        Connection con = JDBCUtil.getConnection();
        List<Pick> picks=new ArrayList<Pick>();
        try{
            Statement statement=con.createStatement();
            String sql="select * from pick where description like '%其他%' and driver_id="+id+" and pick_time is null order by leave_time asc";
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
                Pick pick=new Pick();
                String time;
                pick.setConf_id(rs.getInt("conf_id"));
                time= String.valueOf(rs.getTimestamp("leave_time"));
                time=time.replace(".0","");
                pick.setLeave_time(time);
                pick.setDescription(rs.getString("description"));
                picks.add(pick);
            }
        }catch(SQLException se){
            se.printStackTrace() ;
        }
        return picks;
    }

    @Override
    public void updatestatus(List<Pick> picks,int id) {
        Connection con = JDBCUtil.getConnection();
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        System.out.println(timeStamp);
        try{
            Statement statement=con.createStatement();
            String sql,sql1;
            for(int i=0;i<picks.size();i++){
                String str=picks.get(i).getLeave_time();
                Timestamp timestamp= Timestamp.valueOf(str);
                sql="update pick set pick_time='"+timeStamp+"' where conf_id='"+picks.get(i).getConf_id()+"' and leave_time='"+timestamp+"'";
                statement.executeUpdate(sql);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void driverconfirm(List<Pick> picks) {
        Connection con = JDBCUtil.getConnection();
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        System.out.println(timeStamp);
        try{
            Statement statement=con.createStatement();
//            conf_id              int not null,
//                    driver_id            int,
//            pick_time            datetime,
//            leave_time           datetime,
//            description          varchar(255),
//                    driver_confirm       tinyint,
//                    conferee_confirm     tinyint,
            String sql,sql1;
            for(int i=0;i<picks.size();i++){
                String str=picks.get(i).getLeave_time();
                Timestamp timestamp= Timestamp.valueOf(str);
                sql="update pick set driver_confirm='1' where conf_id='"+picks.get(i).getConf_id()+"' and leave_time='"+timestamp+"'";
                statement.executeUpdate(sql);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Pick> findPassConfirm(int id) {
        Connection con = JDBCUtil.getConnection();
        List<Pick> picks=new ArrayList<Pick>();
        try{
            Statement statement=con.createStatement();
//            conf_id              int not null,
//                    driver_id            int,
//            pick_time            datetime,
//            leave_time           datetime,
//            description          varchar(255),
//                    driver_confirm       tinyint,
//                    conferee_confirm     tinyint,
            String sql="select * from pick where conferee_confirm='1' and driver_id ='"+id+"' and driver_confirm is null order by leave_time asc";
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
                Pick pick=new Pick();
                String time;
                pick.setConf_id(rs.getInt("conf_id"));
                time= String.valueOf(rs.getTimestamp("leave_time"));
                time=time.replace(".0","");
                pick.setLeave_time(time);
                pick.setDescription(rs.getString("description"));
                picks.add(pick);
            }
        }catch(SQLException se){
            se.printStackTrace() ;
        }
        return picks;
    }
}
