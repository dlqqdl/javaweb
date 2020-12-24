package dao.organDao.impl;

import dao.organDao.AttendMeetingDao;
import util.ConnectionFactory;
import vo.organVo.Conferee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendMeetingDaoImpl implements AttendMeetingDao {
    @Override
    public List<Conferee> getConf(int meetid) {
        List list=new ArrayList();
        Connection conn= ConnectionFactory.getConnection();
        String sql="SELECT conferee.conf_id,conferee.name,conferee.tel,conferee.email FROM attendmeeting,conferee WHERE attendmeeting.meet_id=? AND attendmeeting.conf_id=conferee.conf_id";
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,meetid);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                Integer confid= Integer.valueOf(resultSet.getString("conferee.conf_id"));
                Integer tel= Integer.valueOf(resultSet.getString("conferee.tel"));
                String email = resultSet.getString("conferee.email");
                String name = resultSet.getString("conferee.name");
                Conferee conferee=new Conferee(confid,name,tel,email);
                list.add(conferee);
                System.out.println(name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
