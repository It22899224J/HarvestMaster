package com.Backend.HarvestMaster.Order.Model;

import com.Backend.HarvestMaster.LogisticHandler.Model.Buyer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;

    private Integer cartId;

    @ManyToOne
    @JoinColumn(name = "cus_id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private PurchaseOrder order;

    private String customerName;
    private String deliveryAddress;
    private String pickupAddress;
    private LocalDateTime deliveryDate;
    private String driverName;
    private String driverId;
    private String vehicleNumber;
    private String order_status = "pending";
    private String payment_status = "pending";
}

