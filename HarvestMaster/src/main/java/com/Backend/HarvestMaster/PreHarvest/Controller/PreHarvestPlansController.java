package com.Backend.HarvestMaster.PreHarvest.Controller;

import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestPlans;
import com.Backend.HarvestMaster.PreHarvest.Service.PreHarvestPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/preHarvestPlans")
public class PreHarvestPlansController {
    @Autowired
    private PreHarvestPlansService preHarvestPlansService;

    @PostMapping("/add")
    public String add (@RequestBody PreHarvestPlans preHarvestPlans){
        preHarvestPlansService.createPreHarvestPlan(preHarvestPlans);
        return "New Pre-Harvest Plan is Added.";
    }

}
