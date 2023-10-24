package com.example.dachothuenha.Service;

import com.example.dachothuenha.Model.Product;
import com.example.dachothuenha.Model.User;


import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public void insertUser(User user) throws ClassNotFoundException;


    public boolean checkEmail(String username);

    List<User> showAccUser() throws SQLException, ClassNotFoundException;

    User selectUser(int id) throws SQLException, ClassNotFoundException;

    void updateStatusForUser(int id) throws SQLException, ClassNotFoundException;

    void updateLockStatusForUser(int id) throws SQLException, ClassNotFoundException;

    List<User> showUserInformation() throws ClassNotFoundException, SQLException;

     User showEditProfileUser(int id) throws SQLException, ClassNotFoundException;

    boolean updateProfileUser(User user) throws ClassNotFoundException, SQLException;

    List<Product> showProductInformation() throws SQLException, ClassNotFoundException;
    Product showEditProfileProduct(int id) throws ClassNotFoundException, SQLException;
    boolean updateProfileProduct(Product product) throws ClassNotFoundException, SQLException;
}
