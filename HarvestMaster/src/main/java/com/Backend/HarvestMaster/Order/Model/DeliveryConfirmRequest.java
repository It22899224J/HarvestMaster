package com.Backend.HarvestMaster.Order.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryConfirmRequest {
    @JsonProperty("delivery_id")
    private Long deliveryId;
}
