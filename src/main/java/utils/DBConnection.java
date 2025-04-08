package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://172.80.237.53:3306/db_s2_ETU003337?useSSL=false&serverTimezone=UTC";
    private static final String USER = "ETU003337";
    private static final String PASSWORD = "xwZaRbso";

    public static Connection getConn() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC MySQL introuvable", e);
        }
    }
}
