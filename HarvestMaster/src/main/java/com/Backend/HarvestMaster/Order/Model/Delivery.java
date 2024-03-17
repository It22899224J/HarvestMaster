package com.Backend.HarvestMaster.Order.Model;

import com.Backend.HarvestMaster.LogisticHandler.Model.Buyer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
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
