package com.example.dachothuenha.LoginUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ThueNha";
    private static final String DB_USER = "namca";
    private static final String DB_PASSWORD = "2004";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
