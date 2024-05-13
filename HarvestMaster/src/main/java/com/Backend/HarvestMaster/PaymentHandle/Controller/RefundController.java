package com.Backend.HarvestMaster.PaymentHandle.Controller;

import com.Backend.HarvestMaster.PaymentHandle.Model.RefundInfoRequest;
import com.Backend.HarvestMaster.PaymentHandle.Service.RefundInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/refunds")
public class RefundController {

    private final RefundInfoService refundInfoService;

    @Autowired
    public RefundController(RefundInfoService refundInfoService) {
        this.refundInfoService = refundInfoService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRefund(@RequestBody RefundInfoRequest request) {
        return refundInfoService.createRefund(request);
    }
}
