package com.example.dachothuenha.Service;

import com.example.dachothuenha.Model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public void insertUser(User user) throws ClassNotFoundException;


    public boolean checkEmail(String username);
}
