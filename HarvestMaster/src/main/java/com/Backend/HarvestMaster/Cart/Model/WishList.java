package com.Backend.HarvestMaster.Cart.Model;

import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import com.Backend.HarvestMaster.LogisticHandler.Model.Buyer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wishList_items")
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ItemId;
    @Enumerated(EnumType.STRING)
    private Availability availability;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_Id")
    private Inventory inventory;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_Id")
    private Buyer buyer;

    public enum Availability {
        Available,
        Unavailable,
    }
}
