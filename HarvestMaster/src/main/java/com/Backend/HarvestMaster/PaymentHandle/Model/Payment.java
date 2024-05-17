package com.Backend.HarvestMaster.PaymentHandle.Model;

import com.Backend.HarvestMaster.LogisticHandler.Model.Buyer;
import com.Backend.HarvestMaster.User.Model.User;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cus_id")
    private Buyer buyer;

    private String name;
    private String accountNo;
    private Date date;
    private double amount;
    private String status;


}
