package com.Backend.HarvestMaster.PaymentHandle.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class SucessTransactionResponse {
    private Long transactionId;
    private BigDecimal totalPrice;
    private LocalDateTime transactionDate;
    private String paymentMethod;
    private String status;
}
