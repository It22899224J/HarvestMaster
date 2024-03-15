package com.Backend.HarvestMaster.Inventory.Controler;

import com.Backend.HarvestMaster.Farmer.Model.Farmer;
import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import com.Backend.HarvestMaster.Inventory.Service.InventoryService;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/inventory")
public class InventoryControler {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/add")
    public ResponseEntity<Inventory> add(@RequestBody Inventory inventory) {
        inventoryService.saveInventory(inventory);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Inventory> getInventories() {
        return inventoryService.getInventories();
    }

    @DeleteMapping("/inventory/{id}")
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
    public ResponseEntity<Inventory> updateInventory(@PathVariable Integer id, @RequestBody Inventory inventory) {

        try {

            inventoryService.updateInventory(id, inventory);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

}