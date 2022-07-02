package vn.edu.hcmuaf.fit.demo.db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnect {
    private static DBConnect instance;
    private static String DB_URL = "jdbc:mysql://localhost:3306/test1";
    private static String USER = "root";
    private static String PASS = "";
    private Connection connection;

    private DBConnect() {
    }

    public static DBConnect getInstance() {
        if (instance == null) {
            instance = new DBConnect();
        }
        return instance;
    }

    private void connect() throws ClassNotFoundException, SQLException {
        if (connection == null || connection.isClosed()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        }
    }

    public Statement get() {
        try {
            connect();
            return connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
