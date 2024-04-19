package com.Backend.HarvestMaster.PaymentHandle.Model;

import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import com.Backend.HarvestMaster.LogisticHandler.Model.Buyer;
import com.Backend.HarvestMaster.Order.Model.Delivery;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transaction_payment")
public class TransactionPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Inventory inventory;

    private Integer quantity;

    private BigDecimal pricePerUnit;

    private BigDecimal totalPrice;

    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "cus_id")
    private Buyer buyer;

    private String paymentMethod;

    private String paymentSuccessCode;

    private byte[] bankSlipImage;

    private String status;
}
