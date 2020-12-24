package dao.organDao.impl;

import dao.organDao.RemoveMeetingDao;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveMeetingDaoImpl implements RemoveMeetingDao {
    private int i2;
    @Override
    public int removeMeeting(int meetingid) {
        Connection connection = ConnectionFactory.getConnection();
        String sql="DELETE attendmeeting FROM attendmeeting WHERE  meet_id=?";
        try {
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setInt(1,meetingid);
            int i = pstmt.executeUpdate();
            System.out.println("removemeeting:"+i);
            if(i>0){
                System.out.println("删除会议1成功");
            }else {
                System.out.println("删除会议1失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql2="DELETE meeting FROM meeting WHERE  meet_id=?";
        try {
            PreparedStatement pstmt2=connection.prepareStatement(sql2);
            pstmt2.setInt(1,meetingid);
            i2 = pstmt2.executeUpdate();
            System.out.println("removemeeting:"+i2);
            if(i2>0){
                System.out.println("删除会议2成功");

            }else {
                System.out.println("删除会议2失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i2;
    }
}
