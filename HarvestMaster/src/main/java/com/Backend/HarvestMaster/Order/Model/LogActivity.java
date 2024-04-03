package com.Backend.HarvestMaster.Order.Model;

import com.Backend.HarvestMaster.LogisticHandler.Model.Buyer;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "delivery_log_activity")
public class LogActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long LogId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "deliveryId")
    private Delivery deliveryId;

    private String details;

    @CreationTimestamp
    private LocalDateTime date;

    private Integer cartId;



}
