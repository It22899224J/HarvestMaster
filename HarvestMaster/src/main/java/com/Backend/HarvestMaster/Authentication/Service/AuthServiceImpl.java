package com.Backend.HarvestMaster.Authentication.Service;

import com.Backend.HarvestMaster.Farmer.Model.Farmer;
import com.Backend.HarvestMaster.Farmer.Repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{


    @Autowired
    private FarmerRepository farmerRepository;


    @Override
    public Farmer login(Integer userId) {
        return farmerRepository.findById(userId).get();
    }
}
