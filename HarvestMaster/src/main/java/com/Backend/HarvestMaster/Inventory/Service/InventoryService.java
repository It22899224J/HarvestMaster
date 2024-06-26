package com.Backend.HarvestMaster.Inventory.Service;

import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import com.Backend.HarvestMaster.Inventory.Model.InventoryDTO;
import com.Backend.HarvestMaster.Inventory.Model.Update_Inventory;
import com.Backend.HarvestMaster.Inventory.Repository.InventoryRepository;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;

import java.util.List;

public interface InventoryService {


    public boolean deleteInventoryItem(int id) ;


    public InventoryDTO saveInventory(Inventory inventory);

    public List<Inventory> getInventories();

    List<InventoryDTO> getAllInventory();

    public InventoryDTO updateInventory(Integer p_id , Update_Inventory updateInventory);


}


