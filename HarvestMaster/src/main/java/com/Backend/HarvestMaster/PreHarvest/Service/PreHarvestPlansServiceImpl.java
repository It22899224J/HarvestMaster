package com.Backend.HarvestMaster.PreHarvest.Service;

import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestPlans;
import com.Backend.HarvestMaster.PreHarvest.Repository.PreHarvestPlansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PreHarvestPlansServiceImpl implements PreHarvestPlansService{

    @Autowired
    private PreHarvestPlansRepository preHarvestPlansRepository;

    @Override
    public void createPreHarvestPlan(PreHarvestPlans preHarvestPlans) {
        preHarvestPlansRepository.save(preHarvestPlans);
    }

    @Override
    public List<PreHarvestPlans> getAllPreHarvestPlans() {
        return preHarvestPlansRepository.findAll();
    }

    @Override
    public PreHarvestPlans getPreHarvestPlanDetailsById(Integer fieldId) {
        return preHarvestPlansRepository.findById(fieldId).orElseThrow(() -> new NoSuchElementException("PreHarvestPlans with id " + fieldId + " not found"));
    }

    @Override
    public List<PreHarvestPlans> getAllPreHarvestPlansByFarmerID(Integer farmerID) {
        return preHarvestPlansRepository.findByFarmerId(farmerID);
    }


}
