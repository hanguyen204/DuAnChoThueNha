package com.example.dachothuenha.Service;

import com.example.dachothuenha.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserService implements IUserService {
    private String url = "jdbc:mysql://localhost:3306/home_rental";
    private String user = "root";
    private String password = "2004";

    private static final String INSERT_USER = "insert into user (username, phone, password) values (?,?,?);";
    private static final String CHECK_MAIL = "SELECT COUNT(*) FROM user WHERE username = ?";

    private static final String SELECT_ALL_ACCUSER = "select * from accUser";
    private static final String SELECT_ACCUSER = "select id,full_name,phone,status from accUser where id =?";

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
    public List<User> showAccUser() throws SQLException, ClassNotFoundException {
        List<User> list = new ArrayList<>();
        Connection connection = connection();
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ACCUSER);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String full_name = rs.getString("full_name");
            int phone = rs.getInt("phone");
            String status = rs.getString("status");
            list.add(new User(id, full_name, phone, status));
        }
        return list;
    }

    @Override
    public User selectUser(int id) throws SQLException, ClassNotFoundException {
        User users = null;
        PreparedStatement preparedStatement = connection().prepareStatement(SELECT_ACCUSER);
        preparedStatement.setInt(1, id);
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String full_name = rs.getString("full_name");
            int phone = rs.getInt("phone");
            String status = rs.getString("status");
            users = new User(id, full_name, phone, status);
        }
        return users;
    }

    @Override
    public void updateStatusForUser(User user) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = connection().prepareStatement("update accUser set status = ? where id = ?");
        preparedStatement.setString(1, "Đang hoạt động");
        preparedStatement.setInt(2, user.getId());
        preparedStatement.executeUpdate();
        connection().close();
    }

    @Override
    public void updateLockStatusForUser(User users) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = connection().prepareStatement("update accUser set status = ? where id = ?");

        preparedStatement.setString(1, "Khoá");
        preparedStatement.setInt(2, users.getId());
        preparedStatement.executeUpdate();
        connection().close();
    }
}


