package com.Backend.HarvestMaster.PaymentHandle.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {
    private String token;
    private Long amount;
    private String paymentMethodId;
}
