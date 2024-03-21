package com.Backend.HarvestMaster.PreHarvest.Controller;

import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestCosts;
import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestPlans;
import com.Backend.HarvestMaster.PreHarvest.Service.PreHarvestCostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preHarvestCosts")
public class PreHarvestCostsController {
    @Autowired
    private PreHarvestCostsService preHarvestCostsService;

    @PostMapping("/add")
    public ResponseEntity<?> addCost(@RequestBody PreHarvestCosts preHarvestCosts){
        try{PreHarvestCosts cost = preHarvestCostsService.addCost(preHarvestCosts);
            return new ResponseEntity<>(cost, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Failed to add pre-harvest cost", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll/{fieldId}")
    public  ResponseEntity<?> getCostsByFieldId(@PathVariable Integer fieldId){
        try{
            List<PreHarvestCosts> costs = preHarvestCostsService.getAllCosts(fieldId);
            return new ResponseEntity<>(costs,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve pre-harvest costs", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("update/{costId}")
    public ResponseEntity<?> updateCost(@PathVariable Integer costId,@RequestBody PreHarvestCosts preHarvestCosts){
        try{
            PreHarvestCosts cost = preHarvestCostsService.updateCost(costId,preHarvestCosts);
            return new ResponseEntity<>(cost, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Failed to update cost", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{costId}")
    public ResponseEntity<?> deleteCost(@PathVariable Integer costId) {
        try {
            boolean deleted = preHarvestCostsService.deleteCost(costId);
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cost not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete cost", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
