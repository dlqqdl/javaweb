package dao.organDao.impl;


import dao.organDao.ConfereeDao;
import util.ConnectionFactory;
import vo.organVo.DriverPick;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ExilePluto
 * @Date 2020/12/21
 */
public class ConfereeDaoImpl implements ConfereeDao {
    @Override
    public List<DriverPick> unConferee(int flag,int organID) {
        List<DriverPick> list=new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        String sql="";
        if(flag==0){
            sql="SELECT conferee.conf_id,conferee.name,conferee.tel,conferee.sex,pick.driver_id,pick.pick_time,pick.leave_time FROM pick,conferee WHERE pick.conf_id=conferee.conf_id and driver_id is null and \n" +
                    "pick.conf_id in (SELECT attendmeeting.conf_id FROM attendmeeting ,meeting WHERE attendmeeting.meet_id=meeting.meet_id and meeting.organ_id=?);";
        }else {
            sql="SELECT conferee.conf_id,conferee.name,conferee.tel,conferee.sex,pick.driver_id,pick.pick_time,pick.leave_time FROM pick,conferee WHERE pick.conf_id=conferee.conf_id and driver_id is not null and \n" +
                    "pick.conf_id in (SELECT attendmeeting.conf_id FROM attendmeeting ,meeting WHERE attendmeeting.meet_id=meeting.meet_id and meeting.organ_id=73);";
        }
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,organID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int anInt = resultSet.getInt("conferee.conf_id");
                String string = resultSet.getString("conferee.name");
                int anInt1 = resultSet.getInt("conferee.tel");
                String string1 = resultSet.getString("conferee.sex");
                int anInt2 = resultSet.getInt(5);
                Date date = resultSet.getDate(6);
                Date date1 = resultSet.getDate(7);
                DriverPick dp=new DriverPick(anInt,string,anInt1,string1,anInt2,date,date1);
                list.add(dp);
                System.out.println("ConfereeDaoImpl");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

}
