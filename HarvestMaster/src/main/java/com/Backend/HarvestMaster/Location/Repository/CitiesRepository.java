package com.Backend.HarvestMaster.Location.Repository;

import com.Backend.HarvestMaster.Location.Model.Cities;
import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestPlans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitiesRepository extends JpaRepository <Cities,Integer>{
    List<Cities> findByDistrictId(Integer districtId);
}
