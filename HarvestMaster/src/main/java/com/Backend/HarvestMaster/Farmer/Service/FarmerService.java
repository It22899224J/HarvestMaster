package com.Backend.HarvestMaster.Farmer.Service;

import com.Backend.HarvestMaster.Farmer.Model.Farmer;
import com.Backend.HarvestMaster.Farmer.Repository.FarmerRepository;
import com.Backend.HarvestMaster.User.Model.User;
import com.Backend.HarvestMaster.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FarmerService {
    Farmer createFarmer(User user, Farmer farmer);

    Farmer getFarmerByEmail(String email);


//    public Farmer signUpDetails(Farmer details);
//
//    public Farmer profileDetails(Integer id);

//    public Farmer authCheck(String email);
//    public boolean deleteProfile(Integer id);
//
//    public List<Farmer> getAllProfiles();



}
