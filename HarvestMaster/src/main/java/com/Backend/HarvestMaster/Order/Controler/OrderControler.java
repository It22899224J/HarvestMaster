package com.Backend.HarvestMaster.Order.Controler;

import com.Backend.HarvestMaster.Order.Model.PurchaseOrder;
import com.Backend.HarvestMaster.Order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderControler {

    @Autowired
    private OrderService orderService;

    @GetMapping("/allOrders")
    public ResponseEntity<List<PurchaseOrder>> getAllOrders() {
        List<PurchaseOrder> purchaseOrders = orderService.getAllOrders();
        return new ResponseEntity<>(purchaseOrders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getOrderById(@PathVariable("id") Long id) {
        Optional<PurchaseOrder> order = orderService.getOrderById(id);
        return order.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addOrder")
    public ResponseEntity<PurchaseOrder> createOrder(@RequestBody PurchaseOrder purchaseOrder) {
        PurchaseOrder createdPurchaseOrder = orderService.createOrder(purchaseOrder);
        return new ResponseEntity<>(createdPurchaseOrder, HttpStatus.CREATED);
}
}
