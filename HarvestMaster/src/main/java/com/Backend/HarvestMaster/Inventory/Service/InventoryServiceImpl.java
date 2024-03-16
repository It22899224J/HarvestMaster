package com.Backend.HarvestMaster.Inventory.Service;

import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import com.Backend.HarvestMaster.Inventory.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public boolean deleteInventoryItem(int id) {
        inventoryRepository.deleteById(id);
        return true;
    }

    @Override
    public Inventory saveInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }



    @Override
    public List<Inventory> getInventories() {
        return inventoryRepository.findAll();
    }

    @Override
    public List<Inventory> getAllInventory() {
        return null;
    }

    @Override
    public Inventory updateInventory(Integer p_id, Inventory inventory) {

        inventory.setpId(p_id);
        inventoryRepository.save(inventory);
        return inventory;
    }


}
