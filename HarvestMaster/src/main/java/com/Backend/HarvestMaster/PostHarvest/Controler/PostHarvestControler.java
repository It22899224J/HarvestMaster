package com.Backend.HarvestMaster.PostHarvest.Controler;

import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import com.Backend.HarvestMaster.PostHarvest.Service.PostHarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postharvest")
public class PostHarvestControler {


    @Autowired
    private PostHarvestService postHarvestService;

    @PostMapping("/add")
    public ResponseEntity addPostHarvestPlan(@RequestBody PostHarvest postHarvest){

        postHarvestService.addPostHarvestPlans(postHarvest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
