package com.example.dachothuenha.Service;

import com.example.dachothuenha.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserService implements IUserService {
    private String url = "jdbc:mysql://localhost:3306/home_rental";
    private String user = "root";
    private String password = "1";

    private static final String INSERT_USER = "insert into user (username, phone, password) values (?,?,?);";
    private static final String CHECK_MAIL = "SELECT COUNT(*) FROM user WHERE username = ?";
    private String SELECT_ALL_USER = "select * from user";

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

    @Override
    public List<User>showAccUser() throws SQLException, ClassNotFoundException {
        List<User>list = new ArrayList<>();
        Connection connection = connection();
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USER);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
           int id = rs.getInt("id");
           String full_name = rs.getString("full_name");
           String phone = rs.getString("phone");
           String status = rs.getString("status");
           list.add(new User(id,full_name,phone,status));
        }
        return list;
    }

    @Override
    public User selectUser(int id) throws SQLException, ClassNotFoundException {
        User users = null;
        Statement statement = connection().createStatement();
        ResultSet resultSet = statement.executeQuery("select full_name,phone,status from user where id ='" + id +"'");
        while (resultSet.next()) {
            String full_name = resultSet.getString("full_name");
            String phone = resultSet.getString("phone");
            String status = resultSet.getString("status");
            users = new User(full_name, phone, status);
        }
        return users;
    }

    @Override
    public void updateStatusForUser(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = connection().prepareStatement("update user set status = 'Đang hoạt động' where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        connection().close();
    }

    @Override
    public void updateLockStatusForUser(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = connection().prepareStatement("update user set status = 'Khóa' where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        connection().close();
    }
}


