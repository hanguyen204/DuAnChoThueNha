package com.example.dachothuenha.Model;

public class User {
    private int id;
    private String userName;
    private String full_name;

    public User(int id, String userName, String full_name, String phone, String status, String password) {
        this.id = id;
        this.userName = userName;
        this.full_name = full_name;
        this.phone = phone;
        this.status = status;
        this.password = password;
    }

    private String phone;

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;
    private String password;


    public User(int id, String full_name, int phone, String status) {
    }


    public User(String userName, String phone, String password) {
        this.userName = userName;
        this.phone = phone;
        this.password = password;
    }

    public User(int id, String userName, String phone, String password) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
