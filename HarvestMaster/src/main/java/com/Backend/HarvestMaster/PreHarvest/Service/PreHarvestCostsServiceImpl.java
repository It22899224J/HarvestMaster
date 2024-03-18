package com.Backend.HarvestMaster.PreHarvest.Service;

import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestCosts;
import com.Backend.HarvestMaster.PreHarvest.Repository.PreHarvestCostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PreHarvestCostsServiceImpl implements PreHarvestCostsService{

    @Autowired
    private PreHarvestCostsRepository preHarvestCostsRepository;

    @Override
    public PreHarvestCosts addCost(PreHarvestCosts preHarvestCosts) {
        return preHarvestCostsRepository.save(preHarvestCosts);
    }

    @Override
    public List<PreHarvestCosts> getAllCostsByFieldId(Integer fieldId) {
        return preHarvestCostsRepository.getAllCostsByFieldId(fieldId);
    }

    @Override
    public PreHarvestCosts updateCost(Integer costId, PreHarvestCosts preHarvestCosts) {
        preHarvestCosts.setCostId(costId);
        return preHarvestCostsRepository.save(preHarvestCosts);
    }

    @Override
    public boolean deleteCost(Integer costId) {
        preHarvestCostsRepository.deleteById(costId);
        return true;
    }
}
