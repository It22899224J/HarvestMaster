package com.Backend.HarvestMaster.User.Service;

import com.Backend.HarvestMaster.User.Model.USER_ROLES;
import com.Backend.HarvestMaster.User.Model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
//    public User signUpDetails(User details);
//
//    public User profileDetails(Integer id);
//
    User getUserByEmail(String email);

    USER_ROLES getUserRole(String email);
//
//    public User authCheck(String email);
//    public boolean deleteProfile(Integer id);
//
//    public List<User> getAllProfiles();

    String login(String email, String password);
}
