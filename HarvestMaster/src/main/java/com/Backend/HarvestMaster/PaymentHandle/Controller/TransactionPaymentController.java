package com.Backend.HarvestMaster.PaymentHandle.Controller;

import com.Backend.HarvestMaster.PaymentHandle.Model.TransactionPaymentRequest;
import com.Backend.HarvestMaster.PaymentHandle.Service.TransactionPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
