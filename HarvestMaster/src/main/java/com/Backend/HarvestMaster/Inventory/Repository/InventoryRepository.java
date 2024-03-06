package com.Backend.HarvestMaster.Inventory.Repository;

import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
}
