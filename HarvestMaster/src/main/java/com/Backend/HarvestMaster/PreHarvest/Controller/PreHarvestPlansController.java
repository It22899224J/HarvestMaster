package com.Backend.HarvestMaster.PreHarvest.Controller;

import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestPlans;
import com.Backend.HarvestMaster.PreHarvest.Service.PreHarvestPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preHarvestPlans")
public class PreHarvestPlansController {
    @Autowired
    private PreHarvestPlansService preHarvestPlansService;

    @PostMapping("/add")
    public String addPlan (@RequestBody PreHarvestPlans preHarvestPlans){
        preHarvestPlansService.createPreHarvestPlan(preHarvestPlans);
        return "New Pre-Harvest Plan is Added.";
    }

    @GetMapping("/getAll")
    public List<PreHarvestPlans> getAllPlans(){
        return preHarvestPlansService.getAllPreHarvestPlans();
    }

}
