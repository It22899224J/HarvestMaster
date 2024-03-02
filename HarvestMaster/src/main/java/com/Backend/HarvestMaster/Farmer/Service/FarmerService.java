package com.Backend.HarvestMaster.Farmer.Service;

import com.Backend.HarvestMaster.Farmer.Model.Farmer;

import java.util.List;
import java.util.Optional;

public interface FarmerService {

    public Farmer signUpDetails(Farmer details);

    public Farmer profileDetails(Integer id);

    public Farmer authCheck(String userName);
    public boolean deleteProfile(Integer id);

    public List<Farmer> getAllProfiles();



}
