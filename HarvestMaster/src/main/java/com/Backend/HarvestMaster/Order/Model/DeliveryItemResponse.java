package com.Backend.HarvestMaster.Order.Model;


import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryItemResponse {
    private Long deliveryItemId;
    private Long deliveryId;
    private Inventory inventory;
}
