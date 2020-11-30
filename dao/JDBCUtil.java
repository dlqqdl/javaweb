package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC公共工具类: JDBCUtil
 * 链接数据库，断开数据库链接
 */
public class JDBCUtil {
        private static String DB_URL ="jdbc:mysql://localhost:3306/javawebproject";
        private static String DB_DRIVER = "com.mysql.jdbc.Driver";
        private static String DB_USER="root";
        private static String DB_password="dl199808";
        private static Connection connection = null;

        public static Connection getConnection() {
            try {
                Class.forName(DB_DRIVER);
                connection = DriverManager.getConnection(DB_URL,DB_USER,DB_password);
            } catch (ClassNotFoundException e) {
                System.out.println("ClassNotFoundException");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("连接数据库异常");
                e.printStackTrace();
            }
            return connection;
        }

        public static void closeConnection(Connection connection) {
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
}
