package com.Backend.HarvestMaster.Order.Model;

import com.Backend.HarvestMaster.LogisticHandler.Model.Buyer;
import com.Backend.HarvestMaster.PaymentHandle.Model.TransactionPayment;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

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
    @Column(name = "delivery_id")
    private Long deliveryId;

    private Integer cartId;

    @ManyToOne
    @JoinColumn(name = "cus_id")
    private Buyer buyer;

    /*@ManyToOne
    @JoinColumn(name = "order_id")
    private PurchaseOrder order;*/

    private String customerName;
    private String deliveryAddress;
    private String pickupAddress;
    private LocalDateTime deliveryDate;
    @CreationTimestamp
    private LocalDateTime orderDate;
    private String driverName;
    private String driverId;
    private String vehicleNumber;
    private String reason;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'PENDING'")
    private String orderStatus;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'PENDING'")
    private String paymentStatus;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'PENDING'")
    private String deliveryStatus;

    @OneToMany(mappedBy = "delivery")
    private List<TransactionPayment> transactionPayments;
}

