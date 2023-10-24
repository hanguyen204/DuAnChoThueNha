package com.example.dachothuenha.Model;

public class User {
    private int id;
    private String userName;
    private String full_name;
    private String url_image;
    private String address;
    private String status;
    private String password;
    private String phone;

    public User(int id, String userName, String full_name, String url_image, String address, String status, String password, String phone) {
        this.id = id;
        this.userName = userName;
        this.full_name = full_name;
        this.url_image = url_image;
        this.address = address;
        this.status = status;
        this.password = password;
        this.phone = phone;
    }

    public User(int id, String fullName, String phone, String status) {
        this.id = id;
        this.full_name = fullName;
        this.phone = phone;
        this.status = status;
    }

    public User(String fullName, String phone, String status) {
        this.full_name = fullName;
        this.phone = phone;
        this.status = status;
    }

    public User(int id, String username, String urlImage, String fullName, String address, String phone) {
        this.id = id;
        this.userName = username;
        this.url_image = urlImage;
        this.full_name = fullName;
        this.address = address;
        this.phone = phone;
    }

    public User(String username, String url_image, String full_name, String address, String phone) {
        this.userName = username;
        this.url_image = url_image;
        this.full_name = full_name;
        this.address = address;
        this.phone = phone;
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

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }






}
