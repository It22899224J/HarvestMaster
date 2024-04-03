package com.Backend.HarvestMaster.Order.Service;


import com.Backend.HarvestMaster.Order.Model.*;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {
    CommonResponse updateDeliverySchedule(DeliveryRequest delivery);

    CommonResponse createNewDelivery(DeliveryCreateRequest request);

    CommonResponse getPendingDelivery(PendingDeliveryRequest request);

    CommonResponse manageDeliveries(ManageDeliveryRequest request);

    CommonResponse markAsDelivered(DeliveryConfirmRequest delivery);

    CommonResponse deliveryLogActivity();

    CommonResponse orderTotal();
}
