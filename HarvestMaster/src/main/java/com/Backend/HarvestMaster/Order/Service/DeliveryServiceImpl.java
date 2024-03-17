package com.Backend.HarvestMaster.Order.Service;

import com.Backend.HarvestMaster.Cart.Model.CartItem;
import com.Backend.HarvestMaster.Cart.Repository.CartRepository;
import com.Backend.HarvestMaster.Order.Model.CommonResponse;
import com.Backend.HarvestMaster.Order.Model.Delivery;
import com.Backend.HarvestMaster.Order.Model.DeliveryCreateRequest;
import com.Backend.HarvestMaster.Order.Model.DeliveryRequest;
import com.Backend.HarvestMaster.Order.Repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private CartRepository cartRepository;

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
    public CommonResponse updateDeliverySchedule(DeliveryRequest delivery) {
        Delivery deliveryData = deliveryRepository.findDeliveryByDeliveryId(delivery.getDeliveryId());

        if (deliveryData != null) {
            deliveryData.setDeliveryAddress(delivery.getDeliveryAddress());
            deliveryData.setPickupAddress(delivery.getPickupAddress());
            deliveryRepository.save(deliveryData);

            return CommonResponse.builder()
                    .message("Updated")
                    .status(true)
                    .build();
        } else {
            // Handle error or throw exception if the delivery schedule with the given ID doesn't exist

            return CommonResponse.builder()
                    .message("User not found!")
                    .status(false)
                    .build();
        }
    }

    @Override
    public void deleteDeliverySchedule(Long delivery_id) {
        deliveryRepository.deleteById(delivery_id);
    }

    //============================================
    @Override
    public CommonResponse createNewDelivery(DeliveryCreateRequest request) {

        CartItem cartDetails = cartRepository.findById(request.getOrder_id()).get();

        Delivery deliveryData = Delivery.builder()
                .customerName(request.getCustomerName())
                .deliveryAddress(request.getDeliveryAddress())
                .pickupAddress(request.getPickupAddress())
//                 .deliveryDate(request.getDeliveryDate())
                .driverId(request.getDriverId())
                .driverName(request.getDriverName())
                .vehicleNumber(request.getVehicleNumber())
                .order_status("PENDING")
                .payment_status("PENDING")
                .buyer(cartDetails.getBuyer())
                .build();

        deliveryData = deliveryRepository.save(deliveryData);

        return CommonResponse.builder()
                .status(true)
                .message("Data Saved")
                .data(deliveryData)
                .build();
    }
}
