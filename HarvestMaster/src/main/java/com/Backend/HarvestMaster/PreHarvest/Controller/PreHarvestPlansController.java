package com.Backend.HarvestMaster.PreHarvest.Controller;

import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestPlans;
import com.Backend.HarvestMaster.PreHarvest.Service.PreHarvestPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/preHarvestPlans")
public class PreHarvestPlansController {
    @Autowired
    private PreHarvestPlansService preHarvestPlansService;

    @PostMapping("/add")
    public ResponseEntity<?> addPlan(@RequestBody PreHarvestPlans preHarvestPlans) {
        try {
            PreHarvestPlans plan = preHarvestPlansService.createPreHarvestPlan(preHarvestPlans);
            return new ResponseEntity<>(plan,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add pre-harvest plan", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll/{farmerId}")
    public  ResponseEntity<?> getPlansByFarmerId(@PathVariable Integer farmerId){
        try{
            List<PreHarvestPlans> plans = preHarvestPlansService.getAllPreHarvestPlansByFarmerID(farmerId);
            return new ResponseEntity<>(plans,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve pre-harvest plans", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{fieldId}")
    public ResponseEntity<?> getPlanByFieldId(@PathVariable Integer fieldId) {
        try {
            PreHarvestPlans plan = preHarvestPlansService.getPreHarvestPlanDetailsById(fieldId);
            return new ResponseEntity<>(plan, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while processing the request",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("update/{fieldId}")
    public ResponseEntity<?> updatePlan(@PathVariable Integer fieldId,@RequestBody PreHarvestPlans preHarvestPlans){
        try{
            PreHarvestPlans plan = preHarvestPlansService.updatePreHarvestPlan(fieldId,preHarvestPlans);
            return new ResponseEntity<>(plan, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Failed to update plan", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{fieldId}")
    public ResponseEntity<?> deletePlan(@PathVariable Integer fieldId) {
        try {
            boolean deleted = preHarvestPlansService.deletePreHarvestPlan(fieldId);
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Plan not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete plan", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}



