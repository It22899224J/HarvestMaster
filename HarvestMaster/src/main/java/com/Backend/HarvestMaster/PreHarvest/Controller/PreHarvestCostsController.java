package com.Backend.HarvestMaster.PreHarvest.Controller;

import com.Backend.HarvestMaster.PreHarvest.Model.*;
import com.Backend.HarvestMaster.PreHarvest.Model.DTO.PreHarvestCost;
import com.Backend.HarvestMaster.PreHarvest.Model.Projections.PreHarvestCostProjection;
import com.Backend.HarvestMaster.PreHarvest.Service.PreHarvestCostsService;
import com.Backend.HarvestMaster.PreHarvest.Service.PreHarvestPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/preHarvestCosts")
public class PreHarvestCostsController {
    @Autowired
    private PreHarvestCostsService preHarvestCostsService;
    @Autowired
    private PreHarvestPlansService preHarvestPlansService;

    @PostMapping("/add/{fieldId}")
    public ResponseEntity<?> addCost(@RequestBody PreHarvestCost preHarvestCost, @PathVariable Integer fieldId) {
        try {
                if (fieldId == null) {
                    return new ResponseEntity<>("Failed to add pre-harvest cost ", HttpStatus.INTERNAL_SERVER_ERROR);
                }

                PreHarvestPlans currentPlan = preHarvestPlansService.getPreHarvestPlanDetailsById(fieldId);

                    if(currentPlan == null){
                        return new ResponseEntity<>("Failed to add pre-harvest cost ", HttpStatus.INTERNAL_SERVER_ERROR);
                    }

                PreHarvestCosts preHarvestCosts = new PreHarvestCosts();

                preHarvestCosts.setType(preHarvestCost.getType());
                preHarvestCosts.setAmount(preHarvestCost.getAmount());
                preHarvestCosts.setDate(preHarvestCost.getDate());
                preHarvestCosts.setDescription(preHarvestCost.getDescription());

                preHarvestCosts.setPreHarvestPlans(currentPlan);

                return new ResponseEntity<>(preHarvestCostsService.addCost(preHarvestCosts), HttpStatus.OK);
            }catch(Exception e){
                return new ResponseEntity<>("Failed to add pre-harvest cost ", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    @GetMapping("/getAll/{fieldId}")
    public  ResponseEntity<?> getCostsByFieldId(@PathVariable Integer fieldId){
        try{
            List<PreHarvestCostProjection> costs = preHarvestCostsService.getAllCosts(fieldId);
            return new ResponseEntity<>(costs,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve pre-harvest costs", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("update/{fieldId}/{costId}")
    public ResponseEntity<?> updateCost(@PathVariable Integer fieldId,@PathVariable Integer costId,@RequestBody PreHarvestCost preHarvestCost){
        try{
            if (fieldId == null) {
                return new ResponseEntity<>("Failed to add pre-harvest cost ", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            PreHarvestPlans currentPlan = preHarvestPlansService.getPreHarvestPlanDetailsById(fieldId);

            if(currentPlan == null){
                return new ResponseEntity<>("Failed to add pre-harvest cost ", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            PreHarvestCosts preHarvestCosts = new PreHarvestCosts();

            preHarvestCosts.setType(preHarvestCost.getType());
            preHarvestCosts.setAmount(preHarvestCost.getAmount());
            preHarvestCosts.setDate(preHarvestCost.getDate());
            preHarvestCosts.setDescription(preHarvestCost.getDescription());

            preHarvestCosts.setPreHarvestPlans(currentPlan);

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
            return new ResponseEntity<>("Failed to delete cost ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
