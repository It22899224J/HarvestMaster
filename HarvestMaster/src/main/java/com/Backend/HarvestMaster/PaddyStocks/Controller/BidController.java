package com.Backend.HarvestMaster.PaddyStocks.Controller;

import com.Backend.HarvestMaster.PaddyStocks.Model.*;
import com.Backend.HarvestMaster.PaddyStocks.Service.BidService;
import com.Backend.HarvestMaster.PaddyStocks.Service.PaddyStockService;
import com.Backend.HarvestMaster.PaddyStocks.Service.SoldPaddyStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static java.lang.Integer.parseInt;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/bid")
public class BidController {

    @Autowired
    private BidService bidService;

    @Autowired
    private SoldPaddyStockService soldPaddyStockService;

    @Autowired
    private PaddyStockService paddyStockService;

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
    public ResponseEntity<Bid> delete(@PathVariable Integer bid_id){
        try {


            return new ResponseEntity<>( bidService.deleteBid(bid_id),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/accept-bid")
    public ResponseEntity<?> addsoldStock(@RequestBody Map<String, String> requestBody){

        String bidId = requestBody.get("bidId");
        String stockId = requestBody.get("stockId");
        Integer bid_id = parseInt(bidId);
        Integer stock_id = parseInt(stockId);



        try {

            soldPaddyStockService.addSoldPaddyStock(stock_id,bid_id);
            return new ResponseEntity<String>("bid accepted",HttpStatus.OK);

        }  catch (DataIntegrityViolationException e) {
            return new ResponseEntity<String>(" Bid already accepted",HttpStatus.OK);

    }


    }


    //sold paddy stock searched by stockid
    @GetMapping("/getsoldstock/{stockid}")
    @Async
    public ResponseEntity<SoldPaddyStockDTO> getSoldStock(@PathVariable Integer stockid){

        try{
            return new ResponseEntity<>(soldPaddyStockService.getSoldPaddyStock(stockid),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/getAllStocksBuyer/{buyer}")
    @Async
    public ResponseEntity<List<BidBuyerDTO>> getBidStocksByBuyer(@PathVariable String buyer){

        try{
           List<Bid> buyerBids = bidService.getbidbyBuyer(buyer);
            List<BidBuyerDTO> bidBuyerDTOs = new ArrayList<>();

            for (Bid bid : buyerBids) {
                BidBuyerDTO bidBuyerDTO = new BidBuyerDTO();
                bidBuyerDTO.setBidid(bid.getBidid());
                bidBuyerDTO.setPrice(bid.getPrice());
                bidBuyerDTO.setBuyer_email(bid.getBuyer_email());
                bidBuyerDTO.setBuyer_name(bid.getBuyer_name());
                bidBuyerDTO.setCreationDate(bid.getCreationDate());

                // Call a DB function to get relevant paddy stock and convert it to PaddyStockViewDTO
                PaddyStockViewDTO paddyStockView = paddyStockService.getPaddyStockDetails(bid.getStockid()).get(0); // Implement this method


                bidBuyerDTO.setPaddyStockViewDTO(paddyStockView);

                bidBuyerDTOs.add(bidBuyerDTO);
            }
            return new ResponseEntity<>(bidBuyerDTOs,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping("/getsoldstockbybuyer/{buyer}")
    @Async
    public ResponseEntity<SoldPaddyStockDTO> getSoldStockByBuyerName(@PathVariable String buyer){

        try{



            return new ResponseEntity<>(soldPaddyStockService.getSoldPaddyStocksBuyer(buyer),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }




    @PatchMapping("/updatesoldstock/{soldstock}")
    public ResponseEntity<SoldPaddyStockDTO> updateSoldStock(@PathVariable Integer soldstock, SoldPaddyStock soldPaddyStock) {

        try {
            return new ResponseEntity<>(soldPaddyStockService.updateSoldPaddyStock(soldstock, soldPaddyStock), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    }
