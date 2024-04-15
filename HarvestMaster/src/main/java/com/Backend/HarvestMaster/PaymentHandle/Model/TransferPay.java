package com.Backend.HarvestMaster.PaymentHandle.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;


import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TransferPay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paymentIntentId;
    private String amount;
    private String currency;

}
