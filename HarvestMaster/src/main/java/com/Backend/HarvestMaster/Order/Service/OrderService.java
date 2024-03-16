package com.Backend.HarvestMaster.Order.Service;

import com.Backend.HarvestMaster.Order.Model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrders();

    Optional<Order> getOrderById(Long id);

    Order createOrder(Order order);
}