package com.Backend.HarvestMaster.Order.Controler;

import com.Backend.HarvestMaster.Order.Model.*;
import com.Backend.HarvestMaster.Order.Service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/delivery/")
public class DeliveryControler {
    @Autowired
    private final DeliveryService deliveryService;

    public DeliveryControler(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("create")
    public ResponseEntity<CommonResponse> createNewDelivery(@RequestBody DeliveryCreateRequest request) {
        CommonResponse response = deliveryService.createNewDelivery(request);
        if (response.isStatus()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @PostMapping("get/pending")
    public ResponseEntity<CommonResponse> getPendingDelivery(@RequestBody PendingDeliveryRequest request) {
        CommonResponse response = deliveryService.getPendingDelivery(request);
        if (response.isStatus()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @PutMapping("manage")
    public ResponseEntity<CommonResponse> manageDeliveries(@RequestBody ManageDeliveryRequest request) {
        CommonResponse response = deliveryService.manageDeliveries(request);
        if (response.isStatus()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
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

    @PutMapping("/confirm")
    public ResponseEntity<CommonResponse> markAsDelivered(@RequestBody DeliveryConfirmRequest delivery) {
        CommonResponse markAsDelivered = deliveryService.markAsDelivered(delivery);
        if (markAsDelivered.isStatus()) {
            return new ResponseEntity<>(markAsDelivered, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(markAsDelivered, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/log")
    public ResponseEntity<CommonResponse> deliveryLogActivityCommonResponseResponseEntity() {
        CommonResponse deliveryLogActivity = deliveryService.deliveryLogActivity();
        if (deliveryLogActivity.isStatus()) {
            return new ResponseEntity<>(deliveryLogActivity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(deliveryLogActivity, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/total")
    public ResponseEntity<CommonResponse> orderTotalCommonResponseResponseEntity() {
        CommonResponse orderTotal = deliveryService.orderTotal();
        if (orderTotal.isStatus()) {
            return new ResponseEntity<>(orderTotal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(orderTotal, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("get/pending-items")
    public ResponseEntity<CommonResponse> getDeliveryItems(@RequestBody PendingDeliveryRequest request) {
        CommonResponse response = deliveryService.getPendingDelivery(request);
        if (response.isStatus()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/approved-payment")
    public ResponseEntity<CommonResponse> approvedPayment(@RequestBody ManageDeliveryRequest request) {
        CommonResponse response = deliveryService.approvedPayment(request);
        if (response.isStatus()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CommonResponse> deleteEntity(@PathVariable Long id) {
        CommonResponse response = deliveryService.deleteDeliveryById(id);
        if (response.isStatus()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}


