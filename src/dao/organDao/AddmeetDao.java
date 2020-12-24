package dao.organDao;

import util.ConnectionFactory;
import vo.organVo.Meeting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddmeetDao {
    public int insert(Meeting meeting){
        int insFlg=0;
        Connection connection= ConnectionFactory.getConnection();

        String sql="insert into meeting(meet_id,organ_id,topic,num_att,start_time,end_time,address) values(?,?,?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1,meeting.getMeet_id());
            statement.setInt(2,meeting.getOrgan_id());
            statement.setString(3,meeting.getTopic());
            statement.setInt(4,meeting.getNum_att());
            statement.setDate(5,meeting.getStart_time());
            statement.setDate(6,meeting.getEnd_time());
            statement.setString(7,meeting.getAddress());
            //update
            insFlg=statement.executeUpdate();
            if(insFlg!=0){
                System.out.println("添加会议成功");
            }else {
                System.out.println("添加会议失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return insFlg;
    }
}
