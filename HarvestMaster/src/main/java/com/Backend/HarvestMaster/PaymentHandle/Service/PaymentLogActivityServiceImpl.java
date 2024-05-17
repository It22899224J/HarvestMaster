package com.Backend.HarvestMaster.PaymentHandle.Service;

import com.Backend.HarvestMaster.PaymentHandle.Model.PaymentLogActivity;
import com.Backend.HarvestMaster.PaymentHandle.Repositiory.PaymentLogActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PaymentLogActivityServiceImpl implements PaymentLogActivityService {

    @Autowired
    private PaymentLogActivityRepository paymentLogActivityRepository;

    @Override
    public PaymentLogActivity createPaymentLogActivity(String activity) {
        PaymentLogActivity logActivity = new PaymentLogActivity();
        logActivity.setActivity(activity);
        logActivity.setTimestamp(new Date());
        return paymentLogActivityRepository.save(logActivity);
    }

    @Override
    public List<PaymentLogActivity> getAllPaymentLogActivities() {
        return paymentLogActivityRepository.findAll();
    }
}
