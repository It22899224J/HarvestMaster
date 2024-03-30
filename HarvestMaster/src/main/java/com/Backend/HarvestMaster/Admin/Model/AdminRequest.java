package com.Backend.HarvestMaster.Admin.Model;


import com.Backend.HarvestMaster.User.Model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRequest {
    private User user;
    private Admin admin;
}
