package com.Backend.HarvestMaster.Inventory.Service;

import com.Backend.HarvestMaster.Inventory.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService{


    @Autowired
    private InventoryRepository inventoryRepository;


}
