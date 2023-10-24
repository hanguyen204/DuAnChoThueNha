package com.example.dachothuenha.Service;

import com.example.dachothuenha.Model.User;

import java.sql.*;
import java.util.Arrays;


public class UserService implements IUserService {
    private String url = "jdbc:mysql://localhost:3306/home_rental";
    private String user = "root";
    private String password = "2004";

    private static final String INSERT_USER = "insert into user (username, phone, password) values (?,?,?);";
    private static final String CHECK_MAIL = "SELECT COUNT(*) FROM user WHERE username = ?";

    public Connection connection() throws ClassNotFoundException {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    @Override
    public void insertUser(User user) throws ClassNotFoundException {
        Connection connection = connection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean checkEmail(String username) {
        try {
            Connection connection = connection();
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_MAIL);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int count = resultSet.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
