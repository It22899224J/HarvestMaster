package com.Backend.HarvestMaster.Order.Model;


import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryItemRequest {
    private Long deliveryItemId;
    private Long deliveryId;
    private int pId;
}
