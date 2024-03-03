package com.Backend.HarvestMaster.Authentication.model;

public class UserDetails {


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String userName;
    private String type;
    private int id;
    public UserDetails(int id,String userName, String type) {
        this.userName = userName;
        this.type = type;
        this.id = id;
    }

}
