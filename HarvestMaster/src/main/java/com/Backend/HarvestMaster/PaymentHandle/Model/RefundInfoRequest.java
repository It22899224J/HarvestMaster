package com.Backend.HarvestMaster.PaymentHandle.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefundInfoRequest {
    private String bankName;
    private String accountNo;
    private String date;
    private double amount;
    private String reference;
    private String status;
}
