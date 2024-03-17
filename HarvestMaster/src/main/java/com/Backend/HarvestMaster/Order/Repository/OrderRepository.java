package com.Backend.HarvestMaster.Order.Repository;

import com.Backend.HarvestMaster.Order.Model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<PurchaseOrder,Long>{
        }