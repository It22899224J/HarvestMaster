package com.Backend.HarvestMaster.Order.Repository;

import com.Backend.HarvestMaster.Order.Model.Delivery;
import com.Backend.HarvestMaster.Order.Model.DeliveryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryItemRepositiory extends JpaRepository<DeliveryItem, Long> {
    List<DeliveryItem> findByDelivery(Delivery delivery);
}
