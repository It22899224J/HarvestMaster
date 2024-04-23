package com.Backend.HarvestMaster.PaymentHandle.Service;

import com.Backend.HarvestMaster.PaymentHandle.Model.PaymentInfo;
import com.Backend.HarvestMaster.PaymentHandle.Repositiory.PaymentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentInfoServiceImpl implements PaymentInfoService {

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Autowired
    private PaymentLogActivityService paymentLogActivityService;

    @Override
    public List<PaymentInfo> getAllPaymentInfo() {
        return paymentInfoRepository.findAll();
    }

    @Override
    public List<PaymentInfo> getAllPaymentInfoByStatus(String paymentStatus) {
        return paymentInfoRepository.findByPaymentStatus(paymentStatus);
    }

    @Override
    public PaymentInfo getPaymentInfoById(Long id) {
        return paymentInfoRepository.findById(id).orElse(null);
    }

    @Override
    public PaymentInfo createPaymentInfo(PaymentInfo paymentInfo, String paymentStatus) {
        if (paymentStatus == "PENDING") {
            paymentInfo.setPaymentStatus(paymentStatus);
        } else {
            paymentInfo.setPaymentStatus(paymentStatus);
        }
        return paymentInfoRepository.save(paymentInfo);
    }

    @Override
    public PaymentInfo updatePaymentInfo(Long id, PaymentInfo paymentInfo) {
        PaymentInfo existingPaymentInfo = paymentInfoRepository.findById(id).orElse(null);
        if (existingPaymentInfo != null) {

            String currentStatus = existingPaymentInfo.getPaymentStatus();

            paymentInfo.setId(id);
            PaymentInfo updatedPaymentInfo = paymentInfoRepository.save(paymentInfo);
            return updatedPaymentInfo;
        }
        return null;
    }

    @Override
    public void deletePaymentInfo(Long id) {
        paymentInfoRepository.deleteById(id);
    }
}
