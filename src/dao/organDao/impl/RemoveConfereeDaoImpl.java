package dao.organDao.impl;

import dao.organDao.test.RemoveConfereeDao;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveConfereeDaoImpl implements RemoveConfereeDao {
    @Override
    public int removeConferee(int confid) {
        Connection connection = ConnectionFactory.getConnection();
        int i = 0;
        String sql="DELETE attendmeeting FROM attendmeeting WHERE  conf_id=?";
        try {
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setInt(1,confid);
            i= pstmt.executeUpdate();
            System.out.println("removeconf:"+i);
            if(i>0){
                System.out.println("删除人员成功");
            }else {
                System.out.println("删除人员失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }
}
