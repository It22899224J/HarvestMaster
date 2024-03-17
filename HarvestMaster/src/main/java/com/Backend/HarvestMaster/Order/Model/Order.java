package com.Backend.HarvestMaster.Order.Model;

import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import com.Backend.HarvestMaster.LogisticHandler.Model.Buyer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;


    @ManyToOne
    @JoinColumn(name = "cus_id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "pId")
    private Inventory inventory;

    private Date order_date;
    private String order_status = "pending";
    private String payment_status="pending";
}

