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
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId;
    private Integer quantity;
    private Double unitPrice;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_Id")
    private Inventory inventory;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_Id")
    private Buyer buyer;

    private double totalAmount;

    public Double calTotalAmount(){
        totalAmount = this.quantity * this.unitPrice;
        return totalAmount;
    }

}

