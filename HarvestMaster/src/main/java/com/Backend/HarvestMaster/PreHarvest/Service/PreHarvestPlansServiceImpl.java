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

         float area = preHarvestPlans.getFieldArea();
         float seeds;

         if ("Direct Planting".equals(preHarvestPlans.getPlantingMethod())) {
            seeds = (area * 30);
            preHarvestPlans.setSeedsAmount(seeds);
         } else if ("Transplanting".equals(preHarvestPlans.getPlantingMethod())) {
            seeds = (area * 17);
            preHarvestPlans.setSeedsAmount(seeds);
         }

         float initYield= (area*3500);
         preHarvestPlans.setInitialExpectedYield(initYield);

         if("Basmati".equals(preHarvestPlans.getRiceVariety())){
             String harvestTime = "120 - 140 DAS";
             preHarvestPlans.setHarvestTime(harvestTime);
         }
         else if("Keeri Samba".equals(preHarvestPlans.getRiceVariety())){
             String harvestTime = "130 - 150 DAS";
             preHarvestPlans.setHarvestTime(harvestTime);
         }

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

        float area = preHarvestPlans.getFieldArea();
        float seeds;

        if ("Direct Planting".equals(preHarvestPlans.getPlantingMethod())) {
            seeds = (area * 30);
            preHarvestPlans.setSeedsAmount(seeds);
        } else if ("Transplanting".equals(preHarvestPlans.getPlantingMethod())) {
            seeds = (area * 17);
            preHarvestPlans.setSeedsAmount(seeds);
        }

        float initYield= (area*3500);

        preHarvestPlans.setInitialExpectedYield(initYield);

        if("Basmati".equals(preHarvestPlans.getRiceVariety())){
            String harvestTime = "120 - 140 DAS";
            preHarvestPlans.setHarvestTime(harvestTime);
        }
        else if("Keeri Samba".equals(preHarvestPlans.getRiceVariety())){
            String harvestTime = "130 - 150 DAS";
            preHarvestPlans.setHarvestTime(harvestTime);
        }

        return preHarvestPlansRepository.save(preHarvestPlans);
    }

    @Override
    public boolean deletePreHarvestPlan(Integer fieldId) {
        preHarvestPlansRepository.deleteById(fieldId);
        return true;
    }


}
