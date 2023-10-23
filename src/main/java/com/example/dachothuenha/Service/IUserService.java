package com.example.dachothuenha.Service;

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

}
