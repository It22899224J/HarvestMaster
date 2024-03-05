package com.Backend.HarvestMaster.Inventory.Service;

import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import com.Backend.HarvestMaster.Inventory.Repository.InventoryRepository;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;

import java.util.List;

public interface InventoryService {


    public boolean deleteInventoryItem(int id) ;


    public Inventory saveInventory(Inventory inventory);

    public List<Inventory> getInventories();

    List<Inventory> getAllInventory();

    public Inventory updateInventory(Integer p_id , Inventory inventory);
}


