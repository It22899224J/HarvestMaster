package com.Backend.HarvestMaster.Inventory.Controler;

import com.Backend.HarvestMaster.Inventory.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryControler {

    @Autowired
    private InventoryService inventoryService;
}
