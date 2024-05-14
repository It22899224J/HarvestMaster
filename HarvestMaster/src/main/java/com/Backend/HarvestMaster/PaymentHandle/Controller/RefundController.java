package com.Backend.HarvestMaster.PaymentHandle.Controller;

import com.Backend.HarvestMaster.PaymentHandle.Model.*;
import com.Backend.HarvestMaster.PaymentHandle.Service.RefundInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/status")
    public ResponseEntity<List<RefundInfoDTO>> getAllPaymentInfo(@RequestBody RefundInfoDTO refundInfoDTO) {
        List<RefundInfoDTO> refundInfoList = refundInfoService.getRefundsByStatus(refundInfoDTO.getStatus());
        return ResponseEntity.ok().body(refundInfoList);
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<RefundInfo> approveRefundInfo(@PathVariable Long id, @RequestBody RefundInfo refundInfo) {
        RefundInfo updatedRefundInfo = refundInfoService.approvedRefundInformation(id, refundInfo);
        if (updatedRefundInfo != null) {
            return new ResponseEntity<>(updatedRefundInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/reject/{id}")
    public ResponseEntity<RefundInfo> rejectRefundInfo(@PathVariable Long id, @RequestBody RefundInfo refundInfo) {
        RefundInfo updatedRefundInfo = refundInfoService.rejectRefundInformation(id, refundInfo);
        if (updatedRefundInfo != null) {
            return new ResponseEntity<>(updatedRefundInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
