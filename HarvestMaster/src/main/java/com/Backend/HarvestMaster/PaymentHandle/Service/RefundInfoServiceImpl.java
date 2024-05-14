package com.Backend.HarvestMaster.PaymentHandle.Service;

import com.Backend.HarvestMaster.PaymentHandle.Model.*;
import com.Backend.HarvestMaster.PaymentHandle.Repositiory.RefundInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<RefundInfoDTO> getRefundsByStatus(String status) {
        List<RefundInfo> refundInfoList = refundInfoRepository.findByStatus(status);
        List<RefundInfoDTO> refundInfoResponseList = new ArrayList<>();

        for (RefundInfo refundInfo : refundInfoList) {
            RefundInfoDTO refundInfoResponse = new RefundInfoDTO();
            refundInfoResponse.setId(refundInfo.getId());
            refundInfoResponse.setBankName(refundInfo.getBankName());
            refundInfoResponse.setDate(refundInfo.getDate());
            refundInfoResponse.setStatus(refundInfo.getStatus());
            refundInfoResponse.setAmount(refundInfo.getAmount());
            refundInfoResponse.setReference(refundInfo.getReference());
            refundInfoResponse.setBankName(refundInfo.getBankName());
            refundInfoResponse.setAccountNo(refundInfo.getAccountNo());
            refundInfoResponseList.add(refundInfoResponse);
        }

        return refundInfoResponseList;
    }

    @Override
    public RefundInfo approvedRefundInformation(Long id, RefundInfo refundInfo) {
        RefundInfo existingRefundInfo = refundInfoRepository.findById(id).orElse(null);
        if (existingRefundInfo != null) {
                String currentStatus = existingRefundInfo.getStatus();
                refundInfo.setId(id);
                refundInfo.setStatus("APPROVED");
                RefundInfo updatedRefundInfo = refundInfoRepository.save(refundInfo);
                return updatedRefundInfo;
        }
        return null;
    }

    @Override
    public RefundInfo rejectRefundInformation(Long id, RefundInfo refundInfo) {
        RefundInfo existingRefundInfo = refundInfoRepository.findById(id).orElse(null);
        if (existingRefundInfo != null) {
            String currentStatus = existingRefundInfo.getStatus();
            refundInfo.setId(id);
            refundInfo.setStatus("APPROVED");
            RefundInfo rejectdRefundInfo = refundInfoRepository.save(refundInfo);
            return rejectdRefundInfo;
        }
        return null;
    }
}
