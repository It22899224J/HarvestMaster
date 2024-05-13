package com.Backend.HarvestMaster.PaymentHandle.Service;

import com.Backend.HarvestMaster.PaymentHandle.Model.RefundInfo;
import com.Backend.HarvestMaster.PaymentHandle.Model.RefundInfoRequest;
import com.Backend.HarvestMaster.PaymentHandle.Repositiory.RefundInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RefundInfoServiceImpl implements RefundInfoService {
    private final RefundInfoRepository refundInfoRepository;

    @Autowired
    public RefundInfoServiceImpl(RefundInfoRepository refundInfoRepository) {
        this.refundInfoRepository = refundInfoRepository;
    }

    @Override
    public ResponseEntity<String> createRefund(RefundInfoRequest request) {
        try {
            RefundInfo refundInfo = new RefundInfo();
            refundInfo.setBankName(request.getBankName());
            refundInfo.setAccountNo(request.getAccountNo());
            refundInfo.setDate(request.getDate());
            refundInfo.setAmount(request.getAmount());
            refundInfo.setReference(request.getReference());
            refundInfo.setStatus(request.getStatus());

            RefundInfo savedRefundInfo = refundInfoRepository.save(refundInfo);

            if(savedRefundInfo != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Refund created successfully.");
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while creating refund.");
        }
        return null;
    }
}
