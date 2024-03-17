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
    public PreHarvestPlans createPreHarvestPlan(PreHarvestPlans preHarvestPlans) {
        return preHarvestPlansRepository.save(preHarvestPlans);
    }

    @Override
    public List<PreHarvestPlans> getAllPreHarvestPlansByFarmerID(Integer farmerID) {
        return preHarvestPlansRepository.findByFarmerId(farmerID);
    }


    @Override
    public PreHarvestPlans getPreHarvestPlanDetailsById(Integer fieldId) {
        return preHarvestPlansRepository.findById(fieldId).get();
    }

    @Override
    public PreHarvestPlans updatePreHarvestPlan(Integer fieldId, PreHarvestPlans preHarvestPlans) {
        preHarvestPlans.setFieldId(fieldId);
        return preHarvestPlansRepository.save(preHarvestPlans);
    }

    @Override
    public boolean deletePreHarvestPlan(Integer fieldId) {
        preHarvestPlansRepository.deleteById(fieldId);
        return true;
    }


}
