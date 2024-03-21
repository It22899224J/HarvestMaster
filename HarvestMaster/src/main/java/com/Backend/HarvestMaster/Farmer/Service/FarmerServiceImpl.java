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
public class FarmerServiceImpl implements FarmerService{

    @Autowired
    private FarmerRepository farmerRepository;
    private UserRepository userRepository;

    @Autowired
    public FarmerServiceImpl(FarmerRepository farmerRepository, UserRepository userRepository) {
        this.farmerRepository = farmerRepository;
        this.userRepository = userRepository;
    }

    public Farmer createFarmer(User user, Farmer farmer) {
        User savedUser = userRepository.save(user); // Save user first to get generated ID
        farmer.setUser(savedUser); // Set the user for the farmer
        return farmerRepository.save(farmer);
    }

    public Farmer getFarmerByEmail(String email) {
        Optional<Farmer> farmerOptional = farmerRepository.findByUserEmail(email);
        return farmerOptional.orElse(null);
    }

//    @Override
//    public Farmer signUpDetails(Farmer details) {
//        return farmerRepository.save(details);
//    }
//
//    @Override
//    public Farmer profileDetails(Integer id) {
//        return farmerRepository.findById(id).get();
//    }

//    @Override
//    public Farmer authCheck(String email) {
//
//        return farmerRepository.findByemail(email);
//    }


//    @Override
//    public boolean deleteProfile(Integer id) {
//
//        farmerRepository.deleteById(id);
//        return true;
//    }

//    @Override
//    public List<Farmer> getAllProfiles() {
//
//        return farmerRepository.findAll();
//    }
}
