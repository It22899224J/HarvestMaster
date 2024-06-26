package com.Backend.HarvestMaster.PaddyStocks.Controller;


import com.Backend.HarvestMaster.PaddyHealth.Model.Issue;
import com.Backend.HarvestMaster.PaddyStocks.Model.*;
import com.Backend.HarvestMaster.PaddyStocks.Service.PaddyStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.util.List;
import java.util.NoSuchElementException;
@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/paddystock")
public class PaddyStockController {


    @Autowired
    private PaddyStockService paddyStockService;

@PostMapping("/add/{postharvest_id}")
    public ResponseEntity<PaddyStockViewDTO> add(

        @PathVariable Integer postharvest_id,
        @RequestParam ("image_data")MultipartFile image_data,
        @RequestParam ("price") float price,
        @RequestParam ("amount") int amount,
        @RequestParam ("status") Status_stock status
            ){

    try {

        PaddyStock newStock = new PaddyStock();

        byte[] image_byte = image_data.getBytes();

        Blob img = new SerialBlob(image_byte);


        newStock.setImage(img);
        newStock.setPrice(price);
        newStock.setAmount(amount);
        newStock.setStatus(status);




        return new ResponseEntity<>(paddyStockService.addPaddyStock(postharvest_id,newStock), HttpStatus.OK) ;
    }catch (Exception e){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
@PatchMapping("/update/{stock_id}")
public ResponseEntity<PaddyStockViewDTO> updateStock(

        @PathVariable Integer stock_id,
        @RequestParam ("image_data")MultipartFile image_data,
        @RequestParam ("price") float price,
        @RequestParam ("amount") int amount,
        @RequestParam ("status") Status_stock status
){

    try {

        PaddyStock newStock = new PaddyStock();

        byte[] image_byte = image_data.getBytes();

        Blob img = new SerialBlob(image_byte);


        newStock.setImage(img);
        newStock.setPrice(price);
        newStock.setAmount(amount);
        newStock.setStatus(status);




        return new ResponseEntity<>(paddyStockService.updateStock(stock_id,newStock), HttpStatus.OK) ;
    }catch (Exception e){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

@GetMapping("/get/{postharvest_id}")
    public ResponseEntity<PaddyStockViewDTO> getPaddyStock(@PathVariable Integer postharvest_id){
    try {
        return new ResponseEntity<>(paddyStockService.getPaddyStockDetails(postharvest_id).get(0),HttpStatus.OK);
    }catch (NoSuchElementException e)
    {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

    @PostMapping("/filtered-stocks")
    public ResponseEntity<List<PaddyStockAvl>> getPaddyStock(@RequestBody StockSearch stockSearch){




        try {
            System.out.println(stockSearch.getVariety());
            return new ResponseEntity<>(paddyStockService.getPaddyStocksByType(stockSearch.getVariety(),stockSearch.getFert()),HttpStatus.OK);
        }catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/all")
    public ResponseEntity<List<PaddyStockDTO>> getallPaddyStock(){
        try {
            return new ResponseEntity<>(paddyStockService.getAllPaddyStockDetails(),HttpStatus.OK);

        }catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePaddyStock(@PathVariable Integer id){

    try {

        return new ResponseEntity<>(paddyStockService.deletePaddyStock(id),HttpStatus.OK);
    }
    catch (Exception e){

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    }


}
