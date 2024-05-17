package com.Backend.HarvestMaster.Location.Service;

import com.Backend.HarvestMaster.Location.Model.Cities;
import com.Backend.HarvestMaster.Location.Repository.CitiesRepository;
import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestPlans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesServiceImpl implements CitiesService {

     @Autowired
     private CitiesRepository citiesRepository;

    @Override
    public List<Cities> getAllCitiesByDistrictId(Integer districtId) {
        return citiesRepository.findByDistrictId(districtId);
    }
}
