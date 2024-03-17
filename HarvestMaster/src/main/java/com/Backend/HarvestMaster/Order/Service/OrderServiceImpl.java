package com.Backend.HarvestMaster.Order.Service;

import com.Backend.HarvestMaster.Order.Model.PurchaseOrder;
import com.Backend.HarvestMaster.Order.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<PurchaseOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public PurchaseOrder createOrder(PurchaseOrder purchaseOrder) {
        return orderRepository.save(purchaseOrder);
    }

    @Override
    public Optional<PurchaseOrder> getOrderById(Long id) {
        return orderRepository.findById(id);
}

}
