package com.Backend.HarvestMaster.PaymentHandle.Controller;

import com.Backend.HarvestMaster.Order.Model.CommonResponse;
import com.Backend.HarvestMaster.PaymentHandle.Model.SucessTransactionResponse;
import com.Backend.HarvestMaster.PaymentHandle.Model.TransactionPayment;
import com.Backend.HarvestMaster.PaymentHandle.Model.TransactionPaymentRequest;
import com.Backend.HarvestMaster.PaymentHandle.Service.TransactionPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transaction/")
public class TransactionPaymentController {

    @Autowired
    private TransactionPaymentService transactionPaymentService;

    @PostMapping("/process")
    public ResponseEntity<String> processTransaction(@RequestBody TransactionPaymentRequest transactionPaymentRequest) {
        transactionPaymentService.saveTransaction(transactionPaymentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Transaction processed successfully");
    }

    @PostMapping("/sucess")
    public ResponseEntity<?> getSuccessfulTransactions(@RequestBody TransactionPaymentRequest transactionPaymentRequest) {
        List<SucessTransactionResponse> successfulTransactions = transactionPaymentService.sucessTransaction(transactionPaymentRequest);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Success");
        response.put("data", successfulTransactions);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/sucess-all")
    public ResponseEntity<?> getSuccessfulAllTransactions() {
        List<SucessTransactionResponse> successfulAllTransactions = transactionPaymentService.sucessTransactionAll();

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Success");
        response.put("data", successfulAllTransactions);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-transaction/{id}")
    public ResponseEntity<?> getTransactionsById(@PathVariable("id") Long deliveryId) {
        List<SucessTransactionResponse> transactions = transactionPaymentService.getTransactionById(deliveryId);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Success");
        response.put("data", transactions);
        return ResponseEntity.ok().body(response);
    }
}
