package com.Backend.HarvestMaster.Inventory.Repository;

import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
    Inventory findById(int pId);
}
