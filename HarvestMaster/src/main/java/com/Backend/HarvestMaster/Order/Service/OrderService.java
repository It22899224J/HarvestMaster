package com.Backend.HarvestMaster.Order.Service;

import com.Backend.HarvestMaster.Order.Model.PurchaseOrder;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<PurchaseOrder> getAllOrders();

    Optional<PurchaseOrder> getOrderById(Long id);

    PurchaseOrder createOrder(PurchaseOrder purchaseOrder);
}