package com.Backend.HarvestMaster.PaymentHandle.Service;

import com.Backend.HarvestMaster.PaymentHandle.Model.RefundInfo;
import com.Backend.HarvestMaster.PaymentHandle.Model.RefundInfoRequest;
import com.Backend.HarvestMaster.PaymentHandle.Model.RefundInfoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RefundInfoService {
    ResponseEntity<String> createRefund(RefundInfoRequest request);

    List<RefundInfoDTO> getRefundsByStatus(String status);

    RefundInfo approvedRefundInformation(Long id, RefundInfo refundInfo);

    RefundInfo rejectRefundInformation(Long id, RefundInfo refundInfo);
}
