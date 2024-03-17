package com.Backend.HarvestMaster.Order.Service;


import com.Backend.HarvestMaster.Order.Model.Delivery;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {
    List<Delivery>getAllDeliverySchedules();
    Optional<Delivery>getDeliveryScheduleById(Long delivery_id);
    Delivery createDeliverySchedule(Delivery delivery);
    Delivery updateDeliverySchedule(Long delivery_id,Delivery delivery);
    void deleteDeliverySchedule(Long delivery_id);
}
