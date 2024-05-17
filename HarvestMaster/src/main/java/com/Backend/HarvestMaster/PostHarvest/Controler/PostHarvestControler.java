package com.Backend.HarvestMaster.PostHarvest.Controler;

import com.Backend.HarvestMaster.PaddyStocks.Service.BidService;
import com.Backend.HarvestMaster.PaddyStocks.Service.SoldPaddyStockService;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvestAudit;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvestAuditProjection;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvestPlan;
import com.Backend.HarvestMaster.PostHarvest.Service.PostHarvestAuditService;
import com.Backend.HarvestMaster.PostHarvest.Service.PostHarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static java.lang.Integer.parseInt;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/postharvest")
public class PostHarvestControler {


    @Autowired
    private PostHarvestService postHarvestService;

    @Autowired
    private PostHarvestAuditService postHarvestAuditService;

    @Autowired
    private BidService bidService;


    @Autowired
    private SoldPaddyStockService soldPaddyStockService;

    @PostMapping("/add")
    public ResponseEntity<PostHarvest> addPostHarvestPlan(@RequestBody PostHarvest postHarvest){


        return new ResponseEntity<>( postHarvestService.addPostHarvestPlans(postHarvest),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostHarvest> get(@PathVariable Integer id){
        try {
            PostHarvest current = postHarvestService.getPostHarvestDetails(id);
            return new ResponseEntity<>(current, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/all/{f_id}")
    public ResponseEntity<List<PostHarvestPlan>> getAll(@PathVariable Integer f_id){
        try{

            return new ResponseEntity<>(postHarvestService.getPostHarvestPlans(f_id),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PostHarvest> updatePostHarvestPlan(@PathVariable Integer id ,  @RequestBody PostHarvest postHarvest){

        try{



            return new ResponseEntity<>( postHarvestService.updatePostHarvestDetails(id,postHarvest),HttpStatus.OK);

        }catch (NoSuchElementException e){

            return new ResponseEntity<> (HttpStatus.NOT_FOUND);

        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PostHarvest> deleteHarvestPlan(@PathVariable Integer id ){
        try{

            postHarvestService.deletePostHarvestPlan(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @PostMapping("/add-audit")
    public ResponseEntity<PostHarvestAudit> addPostHarvestAudit(@RequestBody Map<String, String> requestBody){

        String harvestDate = requestBody.get("harvestDate");
        String postId = requestBody.get("postId");
        Integer postharvest_id = parseInt(postId);

        PostHarvest postHarvestplan = postHarvestService.getPostHarvestDetails(postharvest_id);
        postHarvestplan.setHarvestDate(harvestDate);

        try {

            PostHarvestAudit newAudit = new PostHarvestAudit();
            if (postHarvestplan != null) {




                //updateing  the harvesting date
                PostHarvest updatedPlan = postHarvestService.addPostHarvestPlans(postHarvestplan);


            }
            return new ResponseEntity<>(postHarvestAuditService.addAudit(postharvest_id),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.OK);


        }


    }

    @GetMapping("/get-audit/{id}")
    public ResponseEntity<PostHarvestAuditProjection> getpostharvestAudit(@PathVariable Integer id){
        try {
            PostHarvestAuditProjection postHarvestAudit = postHarvestAuditService.getAudit(id);
            return new ResponseEntity<>(postHarvestAudit, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/update-audit/{id}")
    public ResponseEntity<PostHarvestAuditProjection> updateAudit(@PathVariable Integer id ,  @RequestBody PostHarvestAudit updatedAudit){

        try{

            PostHarvestAudit existingAudit = postHarvestAuditService.getAuditData(id);

            if (existingAudit == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            // Update only the specified attribute(s) and ensure non-null or non-zero values
            if (updatedAudit.getFuel() != 0.0) {
                existingAudit.setFuel(updatedAudit.getFuel());
            }
            if (updatedAudit.getNo_bags() != 0) {
                existingAudit.setNo_bags(updatedAudit.getNo_bags());
            }
            if ( updatedAudit.getWeight() != 0.0) {
                existingAudit.setWeight(updatedAudit.getWeight());
            }
            if (updatedAudit.getQuality_value() != 0.0) {
                existingAudit.setQuality_value(updatedAudit.getQuality_value());
            }
            if (updatedAudit.getNum_harvesting() != 0) {
                existingAudit.setNum_harvesting(updatedAudit.getNum_harvesting());
            }
            if (updatedAudit.getHarvesting_expense() != 0.0) {
                existingAudit.setHarvesting_expense(updatedAudit.getHarvesting_expense());
            }
            if (updatedAudit.getTransport_expense() != 0.0) {
                existingAudit.setTransport_expense(updatedAudit.getTransport_expense());
            }
            if (updatedAudit.getIncome() != 0.0) {
                existingAudit.setIncome(updatedAudit.getIncome());
            }





            return new ResponseEntity<>(postHarvestAuditService.updateAudit(existingAudit),HttpStatus.OK);




        }catch (NoSuchElementException e){

            return new ResponseEntity<> (HttpStatus.NOT_FOUND);

        }

    }





}
