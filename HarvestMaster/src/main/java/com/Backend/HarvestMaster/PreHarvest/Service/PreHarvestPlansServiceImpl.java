package com.Backend.HarvestMaster.PreHarvest.Service;

import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestPlans;
import com.Backend.HarvestMaster.PreHarvest.Repository.PreHarvestPlansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreHarvestPlansServiceImpl implements PreHarvestPlansService{

    @Autowired
    private PreHarvestPlansRepository preHarvestPlansRepository;

    @Override
    public PreHarvestPlans createPreHarvestPlan(PreHarvestPlans preHarvestPlans) {
        return preHarvestPlansRepository.save(preHarvestPlans);
    }

    @Override
    public List<PreHarvestPlans> getAllPreHarvestPlans() {
        return preHarvestPlansRepository.findAll();
    }

    @Override
    public PreHarvestPlans getPreHarvestPlanDetailsById(Integer field_Id) {
        return preHarvestPlansRepository.getReferenceById(field_Id);
    }
}
