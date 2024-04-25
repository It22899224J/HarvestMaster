package com.Backend.HarvestMaster.PaymentHandle.Service;

import com.Backend.HarvestMaster.PaymentHandle.Model.SucessTransactionResponse;
import com.Backend.HarvestMaster.PaymentHandle.Model.TransactionPayment;
import com.Backend.HarvestMaster.PaymentHandle.Model.TransactionPaymentRequest;

import java.util.List;


public interface TransactionPaymentService {
    public TransactionPayment saveTransaction(TransactionPaymentRequest transactionPayment);

    List<SucessTransactionResponse> sucessTransaction(TransactionPaymentRequest transactionPaymentRequest);

    List<SucessTransactionResponse> sucessTransactionAll();

    List<SucessTransactionResponse> getTransactionById(Long deliveryId);
}
