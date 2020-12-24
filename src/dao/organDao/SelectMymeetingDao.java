package dao.organDao;

import util.ConnectionFactory;
import vo.organVo.Meeting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectMymeetingDao {

    public List<Meeting> selectMymeet(int orgid){
        List<Meeting> meetingList=new ArrayList<Meeting>();
        Connection connection= ConnectionFactory.getConnection();
//        String sql="select meeting.meet_id,meeting.topic,meeting.num_att,meeting.start_time,meeting.end_time,meeting.address" +
//                "from meeting where "
        String sql="select meet_id,topic,num_att,start_time,end_time,address from meeting where organ_id="+orgid;
//        meet_id,
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                Meeting mt=new Meeting();
                mt.setMeet_id(resultSet.getInt("meet_id"));
                mt.setTopic(resultSet.getString("topic"));
                mt.setNum_att(resultSet.getInt("num_att"));
                mt.setStart_time(resultSet.getDate("start_time"));
                mt.setEnd_time(resultSet.getDate("end_time"));
                mt.setAddress(resultSet.getString("address"));
                meetingList.add(mt);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return meetingList;
    }

}
