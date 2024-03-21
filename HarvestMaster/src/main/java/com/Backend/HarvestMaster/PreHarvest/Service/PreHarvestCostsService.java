package com.Backend.HarvestMaster.PreHarvest.Service;

import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestCosts;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PreHarvestCostsService {
    PreHarvestCosts addCost(PreHarvestCosts preHarvestCosts);
    List<PreHarvestCosts> getAllCosts(Integer fieldId);
    PreHarvestCosts updateCost(Integer costId,PreHarvestCosts preHarvestCosts);
    boolean deleteCost(Integer costId);

}
