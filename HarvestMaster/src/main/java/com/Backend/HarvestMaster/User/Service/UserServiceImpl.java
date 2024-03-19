package com.Backend.HarvestMaster.User.Service;


import com.Backend.HarvestMaster.Authentication.Service.JwtUtil;
import com.Backend.HarvestMaster.User.Model.USER_ROLES;
import com.Backend.HarvestMaster.User.Model.User;
import com.Backend.HarvestMaster.User.Model.UserDetails;
import com.Backend.HarvestMaster.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            // Create a new user object without including the password
            User userWithoutPassword = new User();
            userWithoutPassword.setId(user.getId());
            userWithoutPassword.setEmail(user.getEmail());
            userWithoutPassword.setName(user.getName());
            userWithoutPassword.setRole(user.getRole());

            return userWithoutPassword;
        } else {
            return null; // Or handle appropriately if user doesn't exist
        }
    }

    public USER_ROLES getUserRole(String email) {
        // Retrieve the user by email
        User user = userRepository.findByEmail(email);

        // If user exists, return their role
        if (user != null) {
            return user.getRole(); // Assuming getRole() returns the user's role
        } else {
            return null; // Or handle appropriately if user doesn't exist
        }
    }

    @Override
    public String login(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            // User found by email
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(password, user.getPassword())) {
                // Passwords match, generate JWT token
                UserDetails userDetails = new UserDetails(user.getId(), user.getEmail(), user.getName(), user.getRole());
                return jwtUtil.generateToken(userDetails);
            } else {
                // Passwords don't match
                return null;
            }
        } else {
            // User not found
            return null;
        }
    }
}

//    @Override
//    public String authenticate(String email, String password) {
//        User user = userRepository.findByEmail(email);
//        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//            // If authentication is successful, generate a JWT token
//            return jwtUtil.generateToken(user.getEmail(), user.getRole().toString());
//        }
//        return null; // Authentication failed
//    }
//}
