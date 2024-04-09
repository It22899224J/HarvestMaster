package com.Backend.HarvestMaster.Inventory.Controler;

import com.Backend.HarvestMaster.Farmer.Model.Farmer;
import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import com.Backend.HarvestMaster.Inventory.Model.InventoryDTO;
import com.Backend.HarvestMaster.Inventory.Model.Update_Inventory;
import com.Backend.HarvestMaster.Inventory.Service.InventoryService;
import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStock;
import com.Backend.HarvestMaster.PaddyStocks.Model.Status_stock;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/inventory")
public class InventoryControler {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/add")
    public ResponseEntity<InventoryDTO> add(


            @RequestParam ("image") MultipartFile image_data,
            @RequestParam ("product_Name") String Product_Name,
            @RequestParam ("description") String Description,
            @RequestParam ("packege_Type") int Packege_Type,
            @RequestParam ("product_type") String Product_type,
            @RequestParam ("price") double Price

    ){

        try {

            Inventory inventory = new Inventory();


            byte[] image_byte = image_data.getBytes();

            Blob img = new SerialBlob(image_byte);


           inventory.setImage(img);
           inventory.setProduct_Name(Product_Name);
           inventory.setDescription(Description);
           inventory.setPackege_Type(Packege_Type);
           inventory.setProduct_type(Product_type);
           inventory.setPrice(Price);




            return new ResponseEntity<>(inventoryService.saveInventory(inventory), HttpStatus.OK) ;
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/getAll")
    public List<InventoryDTO> getInventories() {return inventoryService.getAllInventory();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Inventory> getInventory(@PathVariable String id) {
        try {
            int pid = Integer.parseInt(id);
            if (inventoryService.deleteInventoryItem(pid)) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @PutMapping("/update/{id}")
    public ResponseEntity<InventoryDTO> updateInventory(@PathVariable Integer id, @RequestBody Update_Inventory updateInventory) {

        try {

            inventoryService.updateInventory(id, updateInventory);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

}