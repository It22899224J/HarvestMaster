package com.Backend.HarvestMaster.PreHarvest.Controller;

import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestPlans;
import com.Backend.HarvestMaster.PreHarvest.Service.PreHarvestPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/preHarvestPlans")
public class PreHarvestPlansController {
    @Autowired
    private PreHarvestPlansService preHarvestPlansService;

    @PostMapping("/add")
    public ResponseEntity<?> addPlan(@RequestBody PreHarvestPlans preHarvestPlans) {
        try {
            preHarvestPlansService.createPreHarvestPlan(preHarvestPlans);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add pre-harvest plan", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllPlans() {
        try {
            List<PreHarvestPlans> plans = preHarvestPlansService.getAllPreHarvestPlans();
            return new ResponseEntity<>(plans, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve pre-harvest plans", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        try {
            PreHarvestPlans plan = preHarvestPlansService.getPreHarvestPlanDetailsById(id);
            return new ResponseEntity<>(plan, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while processing the request",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}



