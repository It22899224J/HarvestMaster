//package com.Backend.HarvestMaster.Authentication.Service;
//
//import com.Backend.HarvestMaster.Authentication.model.UserDetails;
//import com.Backend.HarvestMaster.Farmer.Model.Farmer;
//import com.Backend.HarvestMaster.Farmer.Repository.FarmerRepository;
//import com.Backend.HarvestMaster.User.Model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthServiceImpl implements AuthService{
//
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    public String authenticate(String email, String password) {
//        User user = userRepository(email);
//        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//            String token = jwtUtil.generateToken(email, user.getRole().toString());
//            return token;
//        }
//        return null;
//    }
//}
