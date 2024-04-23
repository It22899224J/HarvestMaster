package com.Backend.HarvestMaster.PaymentHandle.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


import java.util.Date;

@Entity
@Data
public class PaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String accountNo;
    private String hashedAccountNo;
    private Date date;
    private double amount;
    private String reference;
    private String paymentStatus;
}

