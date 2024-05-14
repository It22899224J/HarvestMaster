package com.Backend.HarvestMaster.PaymentHandle.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentInfoResponse {
    private int id;
    private String name;
    private String accountNo;
    private String bankName;
    private String hashedAccountNo;
    private String date;
    private double amount;
    private String reference;
    private String paymentStatus;
}
