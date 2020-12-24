package dao.organDao;

import vo.organVo.Organ;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    public int believe(Organ organ){
        int i=0;
        Connection conn=ConnectionFactory.getConnection();

//        String sql="select * from organ where org_name='"+organ.getOrg_name()+"' and password='"+organ.getPassword()+"'";

        String sql2="select * from organ where org_name=?and password=?";

        try {
            PreparedStatement st=conn.prepareStatement(sql2);
            st.setString(1,organ.getOrg_name());
            st.setString(2, organ.getPassword());
            ResultSet rs=st.executeQuery();
            if(rs.next()==true){
                i=1;
                System.out.println("登录成功");
            }else {
                i=0;
                System.out.println("登录失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    public Organ getid(String name){
        Organ organ=new Organ();
        Connection conn= ConnectionFactory.getConnection();

        try {
            String sql="select organ_id,telephone,password from organ where org_name='"+name+"'";
            PreparedStatement state=conn.prepareStatement(sql);
            ResultSet rs=state.executeQuery();
            if(rs.next()){
                organ.setOrgan_id(rs.getInt("organ_id"));
                organ.setOrg_name(name);
                organ.setPassword(rs.getString("password"));
                organ.setTelephone(rs.getInt("telephone"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return organ;
    }
}
