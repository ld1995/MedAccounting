package by.ld1995tut.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory
{
    private static  final String MYSQLDRIVER = "com.mysql.jdbc.Driver";
    private static  final String URL = "jdbc:mysql://192.168.0.38:3306/patient";
    private static  final String USERNAME = "admin";
    private static  final String PASSWORD = "111";
    private static ConnectionFactory instance;

    private ConnectionFactory() {
        try {
            Class.forName(MYSQLDRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Not found class " + MYSQLDRIVER, e);
        }
    }

    public static synchronized ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
