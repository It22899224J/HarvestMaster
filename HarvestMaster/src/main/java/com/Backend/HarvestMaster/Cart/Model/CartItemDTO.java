package com.Backend.HarvestMaster.Cart.Model;

import com.Backend.HarvestMaster.Inventory.Model.InventoryDTO;
import com.Backend.HarvestMaster.LogisticHandler.Model.Buyer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    private Integer cartItemId;
    private Integer quantity;
    private Double unitPrice;
    private InventoryDTO inventoryDTO;
    private Integer buyerId;
}
