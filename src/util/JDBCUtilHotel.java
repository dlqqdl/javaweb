package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Timgreat
 * @date 2020/11/23 - 22:14
 */
public class JDBCUtilHotel {
    private static String DB_URL="jdbc:mysql://localhost:3306/java?serverTimezone=UTC";
    private static String DB_DRIVER="com.mysql.cj.jdbc.Driver";
    private static String USER_NAME="root";
    private static String PASSWORD="dl199808";
    private static Connection connection = null;
    private static PreparedStatement preparedStatement=null;

    //连接数据库
    public static Connection getConnection() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("连接数据库异常");
            e.printStackTrace();
        }
        return connection;
    }

    //查询公共类
    public static ResultSet execute(Connection connection, PreparedStatement preparedStatement,ResultSet resultSet,String sql, Object[] params ) throws SQLException {
        preparedStatement=connection.prepareStatement(sql);
        //为prepare传参
        for(int i=0;i<params.length;i++)
            preparedStatement.setObject(i+1,params[i]);
        resultSet= preparedStatement.executeQuery();
        return resultSet;
    }
    //增删改公共类
    public static int execute(Connection connection,PreparedStatement preparedStatement,String sql, Object[] params ) throws SQLException {
        preparedStatement=connection.prepareStatement(sql);
        //为prepare传参
        for(int i=0;i<params.length;i++)
            preparedStatement.setObject(i+1,params[i]);
        int updateRows= preparedStatement.executeUpdate();
        return updateRows;
    }
    //关闭连接
    public static boolean closeConnection(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet ) {
        boolean flag=true;
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }
        return flag;
    }
}
