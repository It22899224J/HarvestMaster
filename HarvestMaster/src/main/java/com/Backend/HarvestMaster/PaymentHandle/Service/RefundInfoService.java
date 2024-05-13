package com.Backend.HarvestMaster.PaymentHandle.Service;

import com.Backend.HarvestMaster.PaymentHandle.Model.RefundInfoRequest;
import org.springframework.http.ResponseEntity;

public interface RefundInfoService {
    ResponseEntity<String> createRefund(RefundInfoRequest request);
}
