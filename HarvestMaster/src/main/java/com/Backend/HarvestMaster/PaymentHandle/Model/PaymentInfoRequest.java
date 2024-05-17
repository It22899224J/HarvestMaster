package com.Backend.HarvestMaster.PaymentHandle.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfoRequest {
    private PaymentInfo paymentInfo;
    private String paymentStatus;
}
