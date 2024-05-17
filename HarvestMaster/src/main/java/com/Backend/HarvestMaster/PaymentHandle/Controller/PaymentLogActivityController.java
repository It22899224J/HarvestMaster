package com.Backend.HarvestMaster.PaymentHandle.Controller;

import com.Backend.HarvestMaster.PaymentHandle.Model.PaymentLogActivity;
import com.Backend.HarvestMaster.PaymentHandle.Service.PaymentLogActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-log-activity")
public class PaymentLogActivityController {

    @Autowired
    private PaymentLogActivityService paymentLogActivityService;

    @GetMapping
    public ResponseEntity<List<PaymentLogActivity>> getAllPaymentLogActivities() {
        List<PaymentLogActivity> logActivities = paymentLogActivityService.getAllPaymentLogActivities();
        return new ResponseEntity<>(logActivities, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PaymentLogActivity> createPaymentLogActivity(@RequestBody String activity) {
        PaymentLogActivity logActivity = paymentLogActivityService.createPaymentLogActivity(activity);
        return new ResponseEntity<>(logActivity, HttpStatus.CREATED);
    }
}
