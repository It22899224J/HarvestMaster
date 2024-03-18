package com.Backend.HarvestMaster.PreHarvest.Controller;

import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestCosts;
import com.Backend.HarvestMaster.PreHarvest.Service.PreHarvestCostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            return new ResponseEntity<>("Failed to add pre-harvest plan", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
