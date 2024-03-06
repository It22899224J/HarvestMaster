package com.Backend.HarvestMaster.User.Service;

import com.Backend.HarvestMaster.Farmer.Model.Farmer;
import com.Backend.HarvestMaster.User.Model.User;

import java.util.List;

public interface UserService {
    public User signUpDetails(User details);

    public User profileDetails(Integer id);

    public User authCheck(String email);
    public boolean deleteProfile(Integer id);

    public List<User> getAllProfiles();
}
