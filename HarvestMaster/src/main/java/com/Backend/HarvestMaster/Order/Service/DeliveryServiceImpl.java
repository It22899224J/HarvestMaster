package com.Backend.HarvestMaster.Order.Service;

import com.Backend.HarvestMaster.Order.Model.Delivery;
import com.Backend.HarvestMaster.Order.Repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public List<Delivery> getAllDeliverySchedules() {
        return deliveryRepository.findAll();
    }

    @Override
    public Optional<Delivery> getDeliveryScheduleById(Long delivery_id) {
        return deliveryRepository.findById(delivery_id);
    }

    @Override
    public Delivery createDeliverySchedule(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery updateDeliverySchedule(Long delivery_id, Delivery delivery) {
        if (deliveryRepository.existsById( delivery_id)) {
            delivery.setdelivery_id( delivery_id);
            return deliveryRepository.save(delivery);
        } else {
            // Handle error or throw exception if the delivery schedule with the given ID doesn't exist
            return null;
        }
    }

    @Override
    public void deleteDeliverySchedule(Long delivery_id) {
        deliveryRepository.deleteById(delivery_id);
    }
}
