package com.Backend.HarvestMaster.PreHarvest.Service;

import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestPlans;

import java.util.List;

public interface PreHarvestPlansService {
    public PreHarvestPlans createPreHarvestPlan(PreHarvestPlans preHarvestPlans);
    public List<PreHarvestPlans> getAllPreHarvestPlans();
    public PreHarvestPlans getPreHarvestPlanDetailsById(Integer field_Id);
}
