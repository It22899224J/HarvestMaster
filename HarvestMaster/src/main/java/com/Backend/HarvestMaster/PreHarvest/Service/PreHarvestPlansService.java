package com.Backend.HarvestMaster.PreHarvest.Service;

import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestPlans;

import java.util.List;

public interface PreHarvestPlansService {
    public PreHarvestPlans createPreHarvestPlan(PreHarvestPlans preHarvestPlans);
    public PreHarvestPlans getPreHarvestPlanDetailsById(Integer fieldId);
    public List<PreHarvestPlans> getAllPreHarvestPlansByFarmerID(Integer farmerID);
    public PreHarvestPlans updatePreHarvestPlan(Integer fieldId, PreHarvestPlans preHarvestPlans);
    public boolean deletePreHarvestPlan(Integer fieldId);


}
