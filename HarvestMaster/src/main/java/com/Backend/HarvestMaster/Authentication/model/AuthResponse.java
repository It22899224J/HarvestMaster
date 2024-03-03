package com.Backend.HarvestMaster.Authentication.model;

public class AuthResponse {


    private final String token;
    private final String user;
    public String getUser() {
        return user;
    }



    public AuthResponse(String user,String token) {
        this.user=user;
        this.token = token;
    }
    public String getToken() {
        return token;
    }

}
