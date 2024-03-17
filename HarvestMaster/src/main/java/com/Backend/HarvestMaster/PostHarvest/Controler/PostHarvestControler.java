package com.Backend.HarvestMaster.PostHarvest.Controler;

import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import com.Backend.HarvestMaster.PostHarvest.Service.PostHarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("http://localhost:5173/")
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
    public ResponseEntity<List<PostHarvest>> getAll(@PathVariable Integer f_id){
        try{

            return new ResponseEntity<>(postHarvestService.getPostHarvestPlans(f_id),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PostHarvest> updatePostHarvestPlan(@PathVariable Integer id ,  @RequestBody PostHarvest postHarvest){

        try{


            postHarvestService.updatePostHarvestDetails(id,postHarvest);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (NoSuchElementException e){

            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);

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



}
