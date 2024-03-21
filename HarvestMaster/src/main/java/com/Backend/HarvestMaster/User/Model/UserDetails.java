package com.Backend.HarvestMaster.User.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDetails {
    private int id;
    private String email;
    private String name;
    private USER_ROLES role;
}
