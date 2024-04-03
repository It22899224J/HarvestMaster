package com.Backend.HarvestMaster.Order.Repository;

import com.Backend.HarvestMaster.Order.Model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Delivery findDeliveryByDeliveryId(Long deliveryId);

    List<Delivery> findDeliverysByOrderStatusAndPaymentStatusAndDeliveryStatus(String orderStatus, String paymentStatus, String deliveryStatus);

    Long countByDeliveryStatus(String deliveryStatus);
}
