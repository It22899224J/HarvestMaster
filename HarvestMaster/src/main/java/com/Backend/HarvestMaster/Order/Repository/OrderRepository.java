package com.Backend.HarvestMaster.Order.Repository;

import com.Backend.HarvestMaster.Order.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long>{
        }