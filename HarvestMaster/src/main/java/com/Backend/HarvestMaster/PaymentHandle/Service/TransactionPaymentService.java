package com.Backend.HarvestMaster.PaymentHandle.Service;

import com.Backend.HarvestMaster.PaymentHandle.Model.TransactionPayment;
import com.Backend.HarvestMaster.PaymentHandle.Model.TransactionPaymentRequest;


public interface TransactionPaymentService {
    public TransactionPayment saveTransaction(TransactionPaymentRequest transactionPayment);
}
