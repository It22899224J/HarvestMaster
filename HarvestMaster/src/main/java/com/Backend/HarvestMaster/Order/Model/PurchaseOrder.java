package com.Backend.HarvestMaster.Order.Model;

import com.Backend.HarvestMaster.Inventory.Model.Inventory;
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
@Table(name = "Purchase_Order")
public class PurchaseOrder {
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

}

