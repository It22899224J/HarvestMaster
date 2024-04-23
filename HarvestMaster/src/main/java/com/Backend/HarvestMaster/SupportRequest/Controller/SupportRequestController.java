package com.Backend.HarvestMaster.SupportRequest.Controller;


import com.Backend.HarvestMaster.SupportRequest.Model.SupportRequest;
import com.Backend.HarvestMaster.SupportRequest.SupportRequestService.SupportRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/support")
public class SupportRequestController {

    @Autowired
    private SupportRequestService supportRequestService;


    @PostMapping("/add")
    public ResponseEntity<SupportRequest> add(@RequestBody SupportRequest supportRequest){

        SupportRequest current= supportRequestService.addRequest(supportRequest);


        return new ResponseEntity<>(current,HttpStatus.OK);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<SupportRequest>> getAll(){
        try {
            return new ResponseEntity<>(supportRequestService.getAllRequest(), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping ("/updatesolution/{id}")
    public ResponseEntity<?> updateSolution(@PathVariable Integer id,@RequestBody SupportRequest supportRequest) {

        try {


        SupportRequest current = supportRequestService.getRequest(id);

       current.setSolution(supportRequest.getSolution());
       current.setStatus("Answered");




        return new ResponseEntity<>(supportRequestService.addRequest(current), HttpStatus.OK);
    }catch(NoSuchElementException e){

        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}}
