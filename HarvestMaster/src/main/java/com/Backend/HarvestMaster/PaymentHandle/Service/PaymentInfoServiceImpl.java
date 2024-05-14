package com.Backend.HarvestMaster.PaymentHandle.Service;

import com.Backend.HarvestMaster.PaymentHandle.Model.PaymentInfo;
import com.Backend.HarvestMaster.PaymentHandle.Model.PaymentInfoResponse;
import com.Backend.HarvestMaster.PaymentHandle.Repositiory.PaymentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public List<PaymentInfoResponse> getAllPaymentInfoByStatus(String paymentStatus) {
        List<PaymentInfo> paymentInfoList = paymentInfoRepository.findByPaymentStatus(paymentStatus);
        List<PaymentInfoResponse> paymentInfoResponseList = new ArrayList<>();

        for (PaymentInfo paymentInfo : paymentInfoList) {
            PaymentInfoResponse paymentInfoResponse = new PaymentInfoResponse();
            paymentInfoResponse.setId(paymentInfo.getId().intValue()); // Converting Long to int
            paymentInfoResponse.setName(paymentInfo.getName());
            paymentInfoResponse.setAccountNo(paymentInfo.getAccountNo());
            paymentInfoResponse.setBankName(paymentInfo.getBankName());
            paymentInfoResponse.setHashedAccountNo(paymentInfo.getHashedAccountNo());

            Date dbDate = paymentInfo.getDate();
            Date date = new Date(dbDate.getTime());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = sdf.format(date);
            paymentInfoResponse.setDate(formattedDate);

            paymentInfoResponse.setAmount(paymentInfo.getAmount());
            paymentInfoResponse.setReference(paymentInfo.getReference());
            paymentInfoResponse.setPaymentStatus(paymentInfo.getPaymentStatus());
            paymentInfoResponseList.add(paymentInfoResponse);
        }

        return paymentInfoResponseList;
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
            paymentInfo.setPaymentStatus("DONE");
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
