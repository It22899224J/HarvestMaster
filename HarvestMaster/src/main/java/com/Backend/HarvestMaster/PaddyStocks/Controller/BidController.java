package com.Backend.HarvestMaster.PaddyStocks.Controller;

import com.Backend.HarvestMaster.PaddyStocks.Model.Bid;
import com.Backend.HarvestMaster.PaddyStocks.Service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/bid")
public class BidController {

    @Autowired
    private BidService bidService;


    @PostMapping("/add")
    public ResponseEntity<Bid> add(@RequestBody Bid bid){
        try {
            bidService.addBid(bid);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/getallbids/{paddyStock_id}")
    @Async
    public ResponseEntity<List<Bid>> getAll(@PathVariable Integer paddyStock_id){

        try{
            return new ResponseEntity<>(bidService.getAllBids(paddyStock_id),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping("/getbids/{bid_id}")
    @Async
    public ResponseEntity<Bid> getBidDetails(@PathVariable Integer bid_id){

        try{
            return new ResponseEntity<>(bidService.getBid(bid_id),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/updatebid/{bid_id}")
    public ResponseEntity<Bid> update(@PathVariable Integer bid_id,@RequestBody Bid bid){

        try {
            return new ResponseEntity<>(bidService.updateBid(bid_id,bid),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deletebid/{bid_id}")
    public ResponseEntity<String> delete(@PathVariable Integer bid_id){
        try {
            return new ResponseEntity<>("successfully deleted",HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
