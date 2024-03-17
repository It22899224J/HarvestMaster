package com.Backend.HarvestMaster.Order.Model;

import com.Backend.HarvestMaster.LogisticHandler.Model.Buyer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long delivery_id;

    @ManyToOne
    @JoinColumn(name = "cus_id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String customerName;
    private String deliveryAddress;
    private String pickupAddress;
    private Date deliveryDate;
}
