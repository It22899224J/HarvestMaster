package com.Backend.HarvestMaster.PaymentHandle.Service;

import com.Backend.HarvestMaster.PaymentHandle.Model.PaymentLogActivity;

import java.util.List;

public interface PaymentLogActivityService {
    PaymentLogActivity createPaymentLogActivity(String activity);

    List<PaymentLogActivity> getAllPaymentLogActivities();
}
