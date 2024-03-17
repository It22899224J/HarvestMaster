package com.Backend.HarvestMaster.Order.Repository;

import com.Backend.HarvestMaster.Order.Model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Delivery findDeliveryByDeliveryId(Long deliveryId);


}
