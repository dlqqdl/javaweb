package dao.confereeDao.impl;

import util.JDBCUtil;
import dao.confereeDao.MeetingDao;
import vo.confereeVo.Meeting;
import vo.confereeVo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class MeetingDaoImpl implements MeetingDao {
    @Override
    public List<Meeting> SelctAllMeetingsByUser(User user) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;

        int conf_id=user.getConf_id();
        try {
            connection = JDBCUtil.getConnection();
            String sql= "SELECT meeting.* from attendmeeting, meeting WHERE attendmeeting.conf_id=? and attendmeeting.meet_id=meeting.meet_id;";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,conf_id);
            rs=preparedStatement.executeQuery();
            List<Meeting> meetingList=new LinkedList<>();

            while (rs.next()) {
                Meeting meeting=new Meeting();
                meeting.setMeet_id(rs.getInt("meet_id"));
                meeting.setOrgan_id(rs.getInt("organ_id"));
                meeting.setTopic(rs.getString("topic"));
                meeting.setNum_att(rs.getInt("num_att"));
                meeting.setStart_time(rs.getDate("start_time"));
                meeting.setEnd_time(rs.getDate("end_time"));
                meeting.setAddress(rs.getString("address"));
                meetingList.add(meeting);
            }
            return meetingList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return null;
    }

    @Override
    public List<Meeting> ShowAllMeetings() {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        try {
            connection = JDBCUtil.getConnection();
            String sql= "select meet_id,organ_id,topic,num_att,start_time,end_time,address from meeting";
            preparedStatement=connection.prepareStatement(sql);
            rs=preparedStatement.executeQuery();
            List<Meeting> meetingList=new LinkedList<>();

            while (rs.next()) {
                Meeting meeting=new Meeting();
                meeting.setMeet_id(rs.getInt("meet_id"));
                meeting.setOrgan_id(rs.getInt("organ_id"));
                meeting.setTopic(rs.getString("topic"));
                meeting.setNum_att(rs.getInt("num_att"));
                meeting.setStart_time(rs.getDate("start_time"));
                meeting.setEnd_time(rs.getDate("end_time"));
                meeting.setAddress(rs.getString("address"));
                meetingList.add(meeting);
            }
            return meetingList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                JDBCUtil.closeConnection(connection);
            }
            return null;
        }

    @Override
    public void Insert(Meeting meeting, User user) {
        Connection connection=null;
        ResultSet rs=null;
        int meet_id=meeting.getMeet_id();
        int conf_id=user.getConf_id();
        try {
            connection = JDBCUtil.getConnection();
            Statement stat=connection.createStatement();
            String sql= "insert into attendmeeting(meet_id,conf_id) values (?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,meet_id);
            preparedStatement.setInt(2,conf_id);
            int i=preparedStatement.executeUpdate();
            System.out.println("成功添加"+i+"行");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
    }

    @Override
    public void Cancel(Meeting meeting, User user) {

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        int meet_id=meeting.getMeet_id();
        int conf_id=user.getConf_id();
        try {
            connection = JDBCUtil.getConnection();
            Statement stat=connection.createStatement();
            String sql= "delete from living where conf_id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,conf_id);
            rs=preparedStatement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
   }

    @Override
    public Meeting GetMeeting(int meeting_id) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        Meeting meeting=new Meeting();
        try {
            connection = JDBCUtil.getConnection();
            String sql= "select meet_id,organ_id,topic,num_att,start_time,end_time,address from meeting where meet_id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,meeting_id);
            rs=preparedStatement.executeQuery();
            while (rs.next()) {
                meeting.setMeet_id(rs.getInt("meet_id"));
                meeting.setOrgan_id(rs.getInt("organ_id"));
                meeting.setTopic(rs.getString("topic"));
                meeting.setNum_att(rs.getInt("num_att"));
                meeting.setStart_time(rs.getDate("start_time"));
                meeting.setEnd_time(rs.getDate("end_time"));
                meeting.setAddress(rs.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        if (meeting==null)
            System.out.println("meeting为空！！！");
        return meeting;
    }


}

