package com.Backend.HarvestMaster.Order.Repository;

import com.Backend.HarvestMaster.Order.Model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
