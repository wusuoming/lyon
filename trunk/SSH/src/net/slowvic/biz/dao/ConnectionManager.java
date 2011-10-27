package net.slowvic.biz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager {
    public static Connection getConnection(String url, String user,
        String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        }
        catch (Exception e) {
            throw new RuntimeException("获取数据库连接失败", e);
        }
    }

    public static Connection getMysqlConnection() {
        return getConnection("jdbc:mysql://localhost:3306/snow", "root", "2046");
    }

    public static Connection getConnectionByDatasource() {
        try {
            Context context = new InitialContext();
            DataSource ds = (DataSource) context
                .lookup("java:comp/env/jdbc/snow");
            return ds.getConnection();
        }
        catch (NamingException e) {
            throw new RuntimeException("查找DataSource失败", e);
        }
        catch (SQLException e) {
            throw new RuntimeException("获取数据库连接失败", e);
        }
    }
}
