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

    private static final String SELECT_ALL_ACCUSER = "select id,username,url_image,full_name,address,phone from user";
    private static final String UPDATE_USERS_SQL = "update user set username = ?,url_image= ?, full_name =?, address =?,phone=?  where id = ?;";
    private static final String SELECT_USER_BY_ID = "select username,url_image,full_name,address,phone from user where id =?";

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
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USER);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String full_name = rs.getString("full_name");
            String phone = rs.getString("phone");
            String status = rs.getString("status");
            list.add(new User(id, full_name, phone, status));
        }
        return list;
    }

    @Override
    public User selectUser(int id) throws SQLException, ClassNotFoundException {
        User users = null;
        Statement statement = connection().createStatement();
        ResultSet resultSet = statement.executeQuery("select full_name,phone,status from user where id ='" + id + "'");
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

    public List<User> showUserInformation() throws ClassNotFoundException, SQLException {
        List<User> list = new ArrayList<>();
        PreparedStatement statement = connection().prepareStatement(SELECT_ALL_ACCUSER);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String url_image = rs.getString("url_image");
            String full_name = rs.getString("full_name");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            list.add(new User(id, username, url_image, full_name, address, phone));
        }
        return list;
    }

    public User showEditProfileUser(int id) throws SQLException, ClassNotFoundException {
        User user1 = null;
        PreparedStatement preparedStatement = connection().prepareStatement(SELECT_USER_BY_ID);
        preparedStatement.setInt(1, id);
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String username = rs.getString("username");
            String url_image = rs.getString("url_image");
            String full_name = rs.getString("full_name");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            user1 = new User(username, url_image, full_name, address, phone);

        }
        return user1;
    }

    @Override
    public boolean updateProfileUser(User user) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = connection().prepareStatement(UPDATE_USERS_SQL);
        statement.setString(1, user.getUserName());
        statement.setString(2, user.getUrl_image());
        statement.setString(3, user.getFull_name());
        statement.setString(4, user.getAddress());
        statement.setString(5, user.getPhone());
        statement.setInt(6, user.getId());
        statement.executeUpdate();
        statement.close();
        return false;
    }
}