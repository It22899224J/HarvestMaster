package com.Backend.HarvestMaster.PaymentHandle.Controller;

import com.Backend.HarvestMaster.PaymentHandle.Model.PaymentInfo;
import com.Backend.HarvestMaster.PaymentHandle.Model.PaymentInfoRequest;
import com.Backend.HarvestMaster.PaymentHandle.Service.PaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-info")
public class PaymentInfoController {

    @Autowired
    private PaymentInfoService paymentInfoService;

    @GetMapping
    public ResponseEntity<List<PaymentInfo>> getAllPaymentInfo() {
        List<PaymentInfo> paymentInfos = paymentInfoService.getAllPaymentInfo();
        return new ResponseEntity<>(paymentInfos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentInfo> getPaymentInfoById(@PathVariable Long id) {
        PaymentInfo paymentInfo = paymentInfoService.getPaymentInfoById(id);
        if (paymentInfo != null) {
            return new ResponseEntity<>(paymentInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PaymentInfo> createPaymentInfo(@RequestBody PaymentInfoRequest paymentInfoRequest) {
        PaymentInfo createdPaymentInfo = paymentInfoService.createPaymentInfo(paymentInfoRequest.getPaymentInfo(), paymentInfoRequest.getPaymentStatus());
        return new ResponseEntity<>(createdPaymentInfo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentInfo> updatePaymentInfo(@PathVariable Long id, @RequestBody PaymentInfo paymentInfo) {
        PaymentInfo updatedPaymentInfo = paymentInfoService.updatePaymentInfo(id, paymentInfo);
        if (updatedPaymentInfo != null) {
            return new ResponseEntity<>(updatedPaymentInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentInfo(@PathVariable Long id) {
        paymentInfoService.deletePaymentInfo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/status")
    public ResponseEntity<List<PaymentInfo>> getAllPaymentInfo(@RequestBody PaymentInfoRequest paymentInfoRequest) {
        List<PaymentInfo> paymentInfoList = paymentInfoService.getAllPaymentInfoByStatus(paymentInfoRequest.getPaymentStatus());
        return ResponseEntity.ok(paymentInfoList);
    }
}
