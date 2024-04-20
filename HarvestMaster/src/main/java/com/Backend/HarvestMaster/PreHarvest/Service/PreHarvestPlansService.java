package com.Backend.HarvestMaster.PreHarvest.Service;

import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestPlans;
import java.util.List;

public interface PreHarvestPlansService {
     PreHarvestPlans createPreHarvestPlan(PreHarvestPlans preHarvestPlans);
     List<PreHarvestPlans> getAllPreHarvestPlansByFarmerID(Integer farmerID);
     PreHarvestPlans getPreHarvestPlanDetailsById(Integer fieldId);
     PreHarvestPlans updatePreHarvestPlan(Integer fieldId, PreHarvestPlans preHarvestPlans);
     boolean deletePreHarvestPlan(Integer fieldId);
}
