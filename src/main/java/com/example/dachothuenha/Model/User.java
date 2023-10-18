package com.example.dachothuenha.Model;

public class User {
    private int id;
    private String userName;
    private String url_image;
    private String full_name;
    private String address;
    private String phone;
    private String password;

    public User() {
    }

    public User(String url_image, String full_name, String address, String phone) {
        this.url_image = url_image;
        this.full_name = full_name;
        this.address = address;
        this.phone = phone;
    }

    public User(String userName, String url_image, String full_name, String address, String phone, String password) {
        this.userName = userName;
        this.url_image = url_image;
        this.full_name = full_name;
        this.address = address;
        this.phone = phone;
        this.password = password;
    }

    public User(int id, String userName, String url_image, String full_name, String address, String phone, String password) {
        this.id = id;
        this.userName = userName;
        this.url_image = url_image;
        this.full_name = full_name;
        this.address = address;
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

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
