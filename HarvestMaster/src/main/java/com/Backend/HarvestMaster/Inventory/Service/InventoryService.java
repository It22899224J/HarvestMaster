package com.Backend.HarvestMaster.Inventory.Service;

import com.Backend.HarvestMaster.Inventory.Model.Inventory;

import java.util.List;

public interface InventoryService {


    public Inventory saveInventory(Inventory inventory);

    public List<Inventory> getInventories();

    List<Inventory> getAllInventory();
}


