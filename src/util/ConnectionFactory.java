package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection(){
        Connection conn=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/java?serverTimezone=UTC";
            String user="root";
            String password="dl199808";
//            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dazuoye?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "root", "xjt123456");
            conn=DriverManager.getConnection(url,user,password);
//            System.out.println("");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
