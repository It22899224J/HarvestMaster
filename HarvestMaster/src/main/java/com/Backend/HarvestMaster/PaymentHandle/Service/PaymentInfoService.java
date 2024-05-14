package com.Backend.HarvestMaster.PaymentHandle.Service;

import com.Backend.HarvestMaster.PaymentHandle.Model.PaymentInfo;
import com.Backend.HarvestMaster.PaymentHandle.Model.PaymentInfoResponse;

import java.util.List;

public interface PaymentInfoService {
    List<PaymentInfo> getAllPaymentInfo();

    List<PaymentInfoResponse> getAllPaymentInfoByStatus(String paymentStatus);

    PaymentInfo getPaymentInfoById(Long id);
    PaymentInfo createPaymentInfo(PaymentInfo paymentInfo, String paymentStatus);
    PaymentInfo updatePaymentInfo(Long id, PaymentInfo paymentInfo);
    void deletePaymentInfo(Long id);
}
