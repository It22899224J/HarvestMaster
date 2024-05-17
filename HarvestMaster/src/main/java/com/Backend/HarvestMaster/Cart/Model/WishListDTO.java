package com.Backend.HarvestMaster.Cart.Model;

import com.Backend.HarvestMaster.Inventory.Model.InventoryDTO;
import com.Backend.HarvestMaster.LogisticHandler.Model.Buyer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishListDTO {
    private Integer ItemId;
    private WishList.Availability availability;
    private InventoryDTO inventoryDTO;
    private Buyer buyer;
}
