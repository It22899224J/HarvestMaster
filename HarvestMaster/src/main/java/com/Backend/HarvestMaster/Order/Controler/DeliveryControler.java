package com.Backend.HarvestMaster.Order.Controler;

import com.Backend.HarvestMaster.Order.Model.CommonResponse;
import com.Backend.HarvestMaster.Order.Model.DeliveryCreateRequest;
import com.Backend.HarvestMaster.Order.Service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/delivery/")
public class DeliveryControler {
    @Autowired
    private DeliveryService deliveryService;

   /* @GetMapping
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

    @PutMapping("/update")
    public ResponseEntity<CommonResponse> updateDeliverySchedule(@RequestBody DeliveryRequest delivery) {
        CommonResponse updatedDeliverySchedule = deliveryService.updateDeliverySchedule(delivery);
        if (updatedDeliverySchedule.isStatus()) {
            return new ResponseEntity<>(updatedDeliverySchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(updatedDeliverySchedule, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDeliverySchedule(@PathVariable("id") Long id) {
        deliveryService.deleteDeliverySchedule(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/

    @PostMapping("create")
    public ResponseEntity<?> createNewDelivery(@RequestBody DeliveryCreateRequest request) {
        CommonResponse response = deliveryService.createNewDelivery(request);
        if (response.isStatus()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}


