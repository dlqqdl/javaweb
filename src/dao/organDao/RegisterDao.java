package dao.organDao;

import vo.organVo.Organ;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
    public int insertorgan(Organ organ){
        int i=0;
        Connection conn= ConnectionFactory.getConnection();
        String sql="insert into organ(organ_id,org_name,password,telephone) values(?,?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,organ.getOrgan_id());
            statement.setString(2,organ.getOrg_name());
            statement.setString(3, organ.getPassword());
            statement.setInt(4,organ.getTelephone());
            i=statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }


}
