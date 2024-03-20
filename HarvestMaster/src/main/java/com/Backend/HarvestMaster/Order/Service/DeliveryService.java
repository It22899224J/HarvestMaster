package com.Backend.HarvestMaster.Order.Service;


import com.Backend.HarvestMaster.Order.Model.*;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {
    List<Delivery>getAllDeliverySchedules();
    Optional<Delivery>getDeliveryScheduleById(Long delivery_id);
    Delivery createDeliverySchedule(Delivery delivery);
    void deleteDeliverySchedule(Long delivery_id);
    CommonResponse updateDeliverySchedule(DeliveryRequest delivery);

    CommonResponse createNewDelivery(DeliveryCreateRequest request);

    CommonResponse getPendingDelivery(PendingDeliveryRequest request);

    CommonResponse manageDeliveries(ManageDeliveryRequest request);

}
