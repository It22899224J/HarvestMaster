package com.Backend.HarvestMaster.Order.Service;

import com.Backend.HarvestMaster.Cart.Model.CartItem;
import com.Backend.HarvestMaster.Cart.Repository.CartRepository;
import com.Backend.HarvestMaster.Order.Model.*;
import com.Backend.HarvestMaster.Order.Repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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

        CartItem cartDetails = cartRepository.findById(request.getOrderId()).get();

        Delivery deliveryData = Delivery.builder()
                .customerName(request.getCustomerName())
                .deliveryAddress(request.getDeliveryAddress())
                .pickupAddress(request.getPickupAddress())
//                 .deliveryDate(request.getDeliveryDate())
                .driverId(request.getDriverId())
                .driverName(request.getDriverName())
                .vehicleNumber(request.getVehicleNumber())
                .orderStatus("PENDING")
                .paymentStatus("PENDING")
                .buyer(cartDetails.getBuyer())
                .cartId(request.getOrderId())
                .build();

        deliveryData = deliveryRepository.save(deliveryData);

        return CommonResponse.builder()
                .status(true)
                .message("Data Saved")
                .data(deliveryData)
                .build();
    }

    @Override
    public CommonResponse getPendingDelivery(PendingDeliveryRequest request) {
        List<Delivery> deliveries = deliveryRepository.findDeliverysByOrderStatusAndPaymentStatus(request.getOrderStatus(), request.getPaymentStatus());
        List<PendingDeliveryResponse> pendingDeliveries = new ArrayList<>();

        for (Delivery item : deliveries) {
            pendingDeliveries.add(
                    PendingDeliveryResponse.builder()
                            .customerName(item.getBuyer().getCusName())
                            .orderId(String.valueOf(item.getCartId()))
                            .orderDate(item.getOrderDate().toString())
                            .deliveryAddress(item.getDeliveryAddress())
                            .pickupAddress(item.getPickupAddress())
                            .deliveryDate(item.getDeliveryDate())
                            .deliveryId(item.getDeliveryId())
                            .build()
            );
        }

        return CommonResponse.builder()
                .status(true)
                .message("Pending Deliveries")
                .data(pendingDeliveries)
                .build();

    }

    @Override
    public CommonResponse manageDeliveries(ManageDeliveryRequest request) {
        Optional<Delivery> delivery = deliveryRepository.findById(request.getDeliveryId());
        if (delivery.isEmpty()) {
            return CommonResponse.builder()
                    .status(false)
                    .message("Delivery not found")
                    .data(null)
                    .build();
        }
        Delivery deliveryDetails = delivery.get();
        deliveryDetails.setOrderStatus(request.isOrderStatus()?"APPROVED":"REJECTED");
        deliveryDetails.setReason(request.getReason());
//        deliveryDetails.setReason(StringUtils.hasLength(request.getReason())?request.getReason():null);
        deliveryRepository.save(deliveryDetails);
        return CommonResponse.builder()
                .status(true)
                .message("Delivery Managed")
                .data(null)
                .build();
    }
}
