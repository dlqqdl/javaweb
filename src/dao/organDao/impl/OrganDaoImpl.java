package dao.organDao.impl;

import dao.organDao.OrganDao;
import util.ConnectionFactory;
import vo.organVo.Organ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrganDaoImpl implements OrganDao {
    @Override
    public boolean existOrganId(int organid) {
        List<Organ> list=new ArrayList<Organ>();
        Connection conn= ConnectionFactory.getConnection();
        String sql="SELECT * FROM organ where organ_id=?";
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,organid);
            ResultSet rs=pstmt.executeQuery();
            if(rs!=null){
//                System.out.println("");
                return true;
            }else {
//                System.out.println("");
                return false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean modifyPassword(int id, String password) {
        Connection connection = ConnectionFactory.getConnection();
        String sql="UPDATE organ SET PASSWORD=?  WHERE organ_id=?";
        boolean eflag = false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,password);
            statement.setInt(2,id);
            int i = statement.executeUpdate();
            System.out.println(i);
            if(i==1){
//                System.out.println("");
                eflag=true;
            }else {
                eflag=false;
//                System.out.println("");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return eflag;
    }
}
