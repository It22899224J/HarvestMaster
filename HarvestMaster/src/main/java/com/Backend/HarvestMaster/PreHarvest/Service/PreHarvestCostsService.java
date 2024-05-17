package com.Backend.HarvestMaster.PreHarvest.Service;

import com.Backend.HarvestMaster.PreHarvest.Model.Projections.PreHarvestCostProjection;
import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestCosts;
import java.util.List;

public interface PreHarvestCostsService {
    PreHarvestCosts addCost(PreHarvestCosts preHarvestCosts);
    List<PreHarvestCostProjection> getAllCosts(Integer fieldId);
    PreHarvestCosts getCostById(Integer costId);
    PreHarvestCosts updateCost(Integer costId,PreHarvestCosts preHarvestCosts);
    boolean deleteCost(Integer costId);
}
