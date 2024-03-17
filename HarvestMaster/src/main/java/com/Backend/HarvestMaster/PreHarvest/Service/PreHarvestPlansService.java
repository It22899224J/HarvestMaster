package com.Backend.HarvestMaster.PreHarvest.Service;

import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestPlans;

import java.util.List;

public interface PreHarvestPlansService {
    public void createPreHarvestPlan(PreHarvestPlans preHarvestPlans);
    public List<PreHarvestPlans> getAllPreHarvestPlans();
    public PreHarvestPlans getPreHarvestPlanDetailsById(Integer fieldId);
    public List<PreHarvestPlans> getAllPreHarvestPlansByFarmerID(Integer farmerID);

}
