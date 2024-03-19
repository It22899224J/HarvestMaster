package com.Backend.HarvestMaster.Authentication.model;

import com.Backend.HarvestMaster.User.Model.USER_ROLES;
import com.Backend.HarvestMaster.User.Model.User;

public class LoginResponse {
    private String token;
    private String userRole;
    private User userDetails;

    // Constructor
    public LoginResponse(String token, User userDetails, USER_ROLES userRole) {
        this.token = token;
        this.userDetails = userDetails;
        this.userRole = String.valueOf(userRole);
    }



    // Getters and setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(User userDetails) {
        this.userDetails = userDetails;
    }


    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}









//
//public class AuthResponse {
//
//
//    private final String token;
//    private final String user;
//    public String getUser() {
//        return user;
//    }
//
//
//
//    public AuthResponse(String user,String token) {
//        this.user=user;
//        this.token = token;
//    }
//    public String getToken() {
//        return token;
//    }
//
//}
