package com.Backend.HarvestMaster.Order.Controler;

import com.Backend.HarvestMaster.Order.Model.Delivery;
import com.Backend.HarvestMaster.Order.Service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryControler {
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping
    public ResponseEntity<List<Delivery>> getAllDeliverySchedules() {
        List<Delivery> deliverySchedules = deliveryService.getAllDeliverySchedules();
        return new ResponseEntity<>(deliverySchedules, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getDeliveryScheduleById(@PathVariable("id") Long id) {
        Optional<Delivery> deliverySchedule = deliveryService.getDeliveryScheduleById(id);
        return deliverySchedule.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Delivery> createDeliverySchedule(@RequestBody Delivery delivery) {
        Delivery createdDeliverySchedule = deliveryService.createDeliverySchedule(delivery);
        return new ResponseEntity<>(createdDeliverySchedule, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Delivery> updateDeliverySchedule(@PathVariable("id") Long id, @RequestBody Delivery delivery) {
        Delivery updatedDeliverySchedule = deliveryService.updateDeliverySchedule(id, delivery);
        if (updatedDeliverySchedule != null) {
            return new ResponseEntity<>(updatedDeliverySchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeliverySchedule(@PathVariable("id") Long id) {
        deliveryService.deleteDeliverySchedule(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


