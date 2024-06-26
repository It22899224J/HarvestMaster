package com.Backend.HarvestMaster.Order.Service;


import com.Backend.HarvestMaster.Order.Model.*;

public interface DeliveryService {
    CommonResponse updateDeliverySchedule(DeliveryRequest delivery);

    CommonResponse createNewDelivery(DeliveryCreateRequest request);

    CommonResponse getPendingDelivery(PendingDeliveryRequest request);

    CommonResponse manageDeliveries(ManageDeliveryRequest request);

    CommonResponse markAsDelivered(DeliveryConfirmRequest delivery);

    CommonResponse deliveryLogActivity();

    CommonResponse orderTotal();

    CommonResponse getDeliveryItems(PendingDeliveryRequest request);


    CommonResponse getDeliveryToCart(PendingDeliveryRequest request);

    CommonResponse approvedPayment(ManageDeliveryRequest request);

    CommonResponse deleteDeliveryById(Long deliveryId);
}
