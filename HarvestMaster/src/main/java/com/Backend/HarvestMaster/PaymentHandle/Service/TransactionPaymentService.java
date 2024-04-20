package com.Backend.HarvestMaster.PaymentHandle.Service;

import com.Backend.HarvestMaster.Inventory.Model.InventoryDTO;
import com.Backend.HarvestMaster.Order.Model.CommonResponse;
import com.Backend.HarvestMaster.PaymentHandle.Model.SucessTransactionResponse;
import com.Backend.HarvestMaster.PaymentHandle.Model.TransactionPayment;
import com.Backend.HarvestMaster.PaymentHandle.Model.TransactionPaymentRequest;

import java.util.List;


public interface TransactionPaymentService {
    public TransactionPayment saveTransaction(TransactionPaymentRequest transactionPayment);

    List<TransactionPaymentRequest> sucessTransaction(TransactionPaymentRequest transactionPaymentRequest);

    List<TransactionPaymentRequest> sucessTransactionAll();
}
