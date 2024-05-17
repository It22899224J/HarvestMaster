package com.Backend.HarvestMaster.Authentication.model;

import com.Backend.HarvestMaster.User.Model.USER_ROLES;
import com.Backend.HarvestMaster.User.Model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String token;
    private String userRole;
    private User userDetails;
    private Boolean status;

    public LoginResponse(String token, User userDetails, USER_ROLES userRole, Boolean status) {
        this.token = token;
        this.userDetails = userDetails;
        this.userRole = String.valueOf(userRole);
        this.status = status;
    }
}
