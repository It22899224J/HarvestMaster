package com.Backend.HarvestMaster.Farmer.Service;

import com.Backend.HarvestMaster.Farmer.Model.Farmer;
import com.Backend.HarvestMaster.Farmer.Repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmerServiceImpl implements FarmerService{

    @Autowired
    private FarmerRepository farmerRepository;

    @Override
    public Farmer signUpDetails(Farmer details) {
        return farmerRepository.save(details);
    }

    @Override
    public Farmer profileDetails(Integer id) {
        return farmerRepository.findById(id).get();
    }

    @Override
    public Farmer authCheck(String email) {

        return farmerRepository.findByemail(email);
    }


    @Override
    public boolean deleteProfile(Integer id) {

        farmerRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Farmer> getAllProfiles() {

        return farmerRepository.findAll();
    }
}
