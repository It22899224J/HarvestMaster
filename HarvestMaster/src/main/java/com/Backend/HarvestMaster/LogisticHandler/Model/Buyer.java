package com.Backend.HarvestMaster.LogisticHandler.Model;

import com.Backend.HarvestMaster.PaymentHandle.Model.TransactionPayment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cus_id")
    private int cusId;

    private String cusName;
    private int contactNo;
    private String deliverAddress;
    private String driverName;
    private String driverId;
    private String vehicleNumber;
    private String deliveryDate;
    private double qty;
    private String paddyType;
    @OneToMany(mappedBy = "buyer")
    private List<TransactionPayment> transactionPayments;
}
