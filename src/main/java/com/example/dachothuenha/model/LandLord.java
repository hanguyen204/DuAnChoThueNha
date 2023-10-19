package com.example.dachothuenha.model;

public class LandLord {
    private int id;
    private String avatar;
    private String fullName;
    private String phone;
    private int revenue;
    private int numberHouseForRent;
    private String status;

    public LandLord() {
    }

    public LandLord(int id,String avatar, String fullName, String phone, int revenue, int numberHouseForRent, String status) {
        this.id = id;
        this.avatar = avatar;
        this.fullName = fullName;
        this.phone = phone;
        this.revenue = revenue;
        this.numberHouseForRent = numberHouseForRent;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getNumberHouseForRent() {
        return numberHouseForRent;
    }

    public void setNumberHouseForRent(int numberHouseForRent) {
        this.numberHouseForRent = numberHouseForRent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
