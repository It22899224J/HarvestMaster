package com.Backend.HarvestMaster.LogisticHandler.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
