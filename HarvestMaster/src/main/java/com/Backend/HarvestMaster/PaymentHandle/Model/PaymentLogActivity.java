package com.Backend.HarvestMaster.PaymentHandle.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class PaymentLogActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payment_info_id", nullable = false)
    private PaymentInfo paymentInfo;

    @Column(nullable = false)
    private String activity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date timestamp;
}
