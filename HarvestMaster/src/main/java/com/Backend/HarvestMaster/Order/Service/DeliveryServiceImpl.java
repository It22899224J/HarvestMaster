package com.Backend.HarvestMaster.Order.Service;

import com.Backend.HarvestMaster.Buyer.Repositiory.BuyerRepositiory;
import com.Backend.HarvestMaster.Cart.Repository.CartRepository;
import com.Backend.HarvestMaster.Inventory.Repository.InventoryRepository;
import com.Backend.HarvestMaster.Order.Model.*;
import com.Backend.HarvestMaster.Order.Repository.DeliveryItemRepositiory;
import com.Backend.HarvestMaster.Order.Repository.DeliveryLogActivityRepository;
import com.Backend.HarvestMaster.Order.Repository.DeliveryRepository;
import com.Backend.HarvestMaster.PaymentHandle.Model.TransactionPayment;
import com.Backend.HarvestMaster.PaymentHandle.Repositiory.TransactionPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final CartRepository cartRepository;
    private final DeliveryLogActivityRepository logActivityRepository;
    private final InventoryRepository inventoryRepository;
    private final DeliveryItemRepositiory deliveryItemRepositiory;
    private final BuyerRepositiory buyerRepositiory;
    private final TransactionPaymentRepository transactionPaymentRepository;

    @Override
    public CommonResponse updateDeliverySchedule(DeliveryRequest delivery) {
        Delivery deliveryData = deliveryRepository.findDeliveryByDeliveryId(delivery.getDeliveryId());

        if (deliveryData != null) {
            deliveryData.setDeliveryAddress(delivery.getDeliveryAddress());
            deliveryData.setPickupAddress(delivery.getPickupAddress());
            deliveryRepository.save(deliveryData);

            LogActivity logActivity = LogActivity.builder()
                    .deliveryId(deliveryData)
                    .details("Order Updated")
                    .cartId(deliveryData.getCartId())
                    .build();
            logActivityRepository.save(logActivity);

            return CommonResponse.builder()
                    .message("Updated")
                    .status(true)
                    .build();
        } else {
            return CommonResponse.builder()
                    .message("User not found!")
                    .status(false)
                    .build();
        }
    }


    @Override
    public CommonResponse markAsDelivered(DeliveryConfirmRequest delivery) {
        Delivery deliveryData = deliveryRepository.findDeliveryByDeliveryId(delivery.getDeliveryId());

        if (deliveryData != null) {
            deliveryData.setDeliveryStatus("DELIVERED");
            deliveryRepository.save(deliveryData);

            LogActivity logActivity = LogActivity.builder()
                    .deliveryId(deliveryData)
                    .details("Order Delivered")
                    .cartId(deliveryData.getCartId())
                    .build();
            logActivityRepository.save(logActivity);

            return CommonResponse.builder()
                    .message("Delivered")
                    .status(true)
                    .build();
        } else {
            return CommonResponse.builder()
                    .message("Delivery not found!")
                    .status(false)
                    .build();
        }
    }

    @Override
    public CommonResponse createNewDelivery(DeliveryCreateRequest request) {

//        CartItem cartDetails = cartRepository.findById(request.getOrderId()).get();

        Delivery deliveryData = Delivery.builder()
//                .customerName(request.getCustomerName())
                .deliveryAddress(request.getDeliveryAddress())
                .pickupAddress("HarvestMaster Pvt Ltd Polonnaruwa Road New Town")
//                 .deliveryDate(request.getDeliveryDate())
                .driverId(request.getDriverId())
                .driverName(request.getDriverName())
                .vehicleNumber(request.getVehicleNumber())
                .orderStatus("PENDING")
                .paymentStatus("PENDING")
//                .buyer(cartDetails.getBuyer())
                .cartId(request.getOrderId())
                .build();


        deliveryData = deliveryRepository.save(deliveryData);

        // Store delivery items
        List<DeliveryItem> deliveryItems = request.getDeliveryItems();
        for (DeliveryItem item : deliveryItems) {
            // Set the deliveryId of each delivery item to associate it with the newly created delivery
            item.setDeliveryItemId(deliveryData.getDeliveryId());
            System.out.println(deliveryData.getDeliveryId());

//            item.setInventory();
        }
        List<DeliveryItem> savedDeliveryItems = deliveryItemRepositiory.saveAll(deliveryItems);

        // Associate the saved delivery items with the delivery
        deliveryData.setDeliveryItems(savedDeliveryItems);

        return CommonResponse.builder()
                .status(true)
                .message("Data Saved")
                .data(deliveryData)
                .build();
    }

    @Override
    public CommonResponse getPendingDelivery(PendingDeliveryRequest request) {
        List<Delivery> deliveries = deliveryRepository.findDeliverysByOrderStatusAndPaymentStatusAndDeliveryStatus(request.getOrderStatus(), request.getPaymentStatus(), "PENDING");
        List<PendingDeliveryResponse> pendingDeliveries = new ArrayList<>();

        for (Delivery item : deliveries) {
            pendingDeliveries.add(
                    PendingDeliveryResponse.builder()
                            .customerName(item.getBuyer().getCusName())
//                            .orderId(String.valueOf(item.getDeliveryId()))
                            .deliveryId(item.getDeliveryId())
                            .orderDate(item.getOrderDate().toString())
                            .deliveryAddress(item.getDeliveryAddress())
                            .pickupAddress("HarvestMaster Pvt Ltd Polonnaruwa Road New Town")
                            .deliveryDate(item.getDeliveryDate().toString())
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
        deliveryDetails.setOrderStatus(request.isOrderStatus() ? "APPROVED" : "REJECTED");
        deliveryDetails.setReason(request.getReason());
//        deliveryDetails.setReason(StringUtils.hasLength(request.getReason())?request.getReason():null);
        deliveryRepository.save(deliveryDetails);
        return CommonResponse.builder()
                .status(true)
                .message("Delivery Managed")
                .data(null)
                .build();
    }

    @Override
    public CommonResponse deliveryLogActivity() {
        ArrayList<LogActivityResponse> list = new ArrayList<>();

        List<LogActivity> activities = logActivityRepository.findAll();

        for (LogActivity activity : activities) {
            list.add(
                    LogActivityResponse.builder()
                            .date(activity.getDate().toLocalDate().toString())
                            .time(activity.getDate().toLocalTime().toString())
                            .detail(activity.getDetails())
                            .cartId(activity.getCartId())
                            .build()
            );
        }


        return CommonResponse.builder()
                .status(true)
                .message("Delivery Log Activities")
                .data(list)
                .build();
    }

    @Override
    public CommonResponse orderTotal() {
        long pendingCount = deliveryRepository.countByDeliveryStatus("PENDING");
        long deliveredCount = deliveryRepository.countByDeliveryStatus("DELIVERED");
        long inventoryCount = inventoryRepository.count();
        System.out.println("pendingCount : " + pendingCount);
        System.out.println("deliveredCount : " + deliveredCount);
        System.out.println("inventory_count : " + inventoryCount);

        HashMap<String, Object> map = new HashMap<>();
        map.put("pending_count", pendingCount);
        map.put("delivered_count", deliveredCount);
        map.put("inventory_count", inventoryCount);

        return CommonResponse.builder()
                .status(true)
                .message("Total")
                .data(map)
                .build();
    }

    @Override
    public CommonResponse getDeliveryItems(PendingDeliveryRequest request) {
//        Buyer buyer = buyerRepositiory.findOneById(request.getBuyerId()).orElse(null);
//        if (buyer  == null) {
//            return CommonResponse.builder()
//                    .status(false)
//                    .message("Buyer not found")
//                    .build();
//        }
//        System.out.println(buyer);
        List<Delivery> deliveries = deliveryRepository.findDeliverysByOrderStatusAndPaymentStatusAndDeliveryStatus(
                request.getOrderStatus(), request.getPaymentStatus(), "PENDING");

        List<DeliveryItemResponse> deliveryItemResponses = new ArrayList<>();

        for (Delivery delivery : deliveries) {
            List<DeliveryItem> deliveryItems = deliveryItemRepositiory.findByDelivery(delivery);


            for (DeliveryItem deliveryItem : deliveryItems) {
                deliveryItemResponses.add(
                        DeliveryItemResponse.builder()
                                .deliveryItemId(deliveryItem.getDeliveryItemId())
                                .deliveryId(deliveryItem.getDeliveryItemId())
                                .inventory(deliveryItem.getInventory())
                                .build()
                );
            }

        }
        return CommonResponse.builder()
                .status(true)
                .message("Pending Delivery Items")
                .data(deliveryItemResponses)
                .build();
    }

    @Override
    public CommonResponse getDeliveryToCart(PendingDeliveryRequest request) {
        List<Delivery> deliveries = deliveryRepository.findDeliverysByOrderStatusAndPaymentStatusAndDeliveryStatus(request.getOrderStatus(), request.getPaymentStatus(), "PENDING");
        List<DeliveryViewResponse> pendingDeliveries = new ArrayList<>();

        for (Delivery item : deliveries) {

            List<TransactionPayment> transactions = transactionPaymentRepository.findByDelivery(item);
            BigDecimal totalAmount = transactions.stream().map(TransactionPayment::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);



            pendingDeliveries.add(
                    DeliveryViewResponse.builder()
                            .customerName(item.getBuyer().getCusName())
//                            .orderId(String.valueOf(item.getDeliveryId()))
                            .deliveryId(item.getDeliveryId())
                            .orderDate(item.getOrderDate().toString())
                            .deliveryAddress(item.getDeliveryAddress())
                            .pickupAddress("HarvestMaster Pvt Ltd Polonnaruwa Road New Town")
                            .deliveryDate(item.getDeliveryDate().toString())
                            .deliveryId(item.getDeliveryId())
                            .totalPrice(totalAmount)
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
    public CommonResponse approvedPayment(ManageDeliveryRequest request) {
        Optional<Delivery> delivery = deliveryRepository.findById(request.getDeliveryId());
        if (delivery.isEmpty()) {
            return CommonResponse.builder()
                    .status(false)
                    .message("Delivery not found")
                    .data(null)
                    .build();
        }
        Delivery deliveryDetails = delivery.get();
        deliveryDetails.setPaymentStatus(request.isPaymentStatus() ? "APPROVED" : "REJECTED");
        deliveryDetails.setReason(request.getReason());
//        deliveryDetails.setReason(StringUtils.hasLength(request.getReason())?request.getReason():null);
        deliveryRepository.save(deliveryDetails);
        return CommonResponse.builder()
                .status(true)
                .message("Delivery Managed")
                .data(null)
                .build();
    }

    @Override
    public CommonResponse deleteDeliveryById(Long deliveryId) {
        deliveryRepository.deleteById(deliveryId);
        return CommonResponse.builder()
                .status(true)
                .message("Delivery Delete")
                .build();
    }
}

