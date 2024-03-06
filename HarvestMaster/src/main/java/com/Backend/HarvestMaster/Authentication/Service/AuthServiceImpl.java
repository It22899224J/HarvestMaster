package com.Backend.HarvestMaster.Authentication.Service;

import com.Backend.HarvestMaster.Authentication.model.UserDetails;
import com.Backend.HarvestMaster.Farmer.Model.Farmer;
import com.Backend.HarvestMaster.Farmer.Repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{


    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public String jwtAuth(UserDetails userDetails) {
        return jwtUtil.generateToken(userDetails);
    }
}
