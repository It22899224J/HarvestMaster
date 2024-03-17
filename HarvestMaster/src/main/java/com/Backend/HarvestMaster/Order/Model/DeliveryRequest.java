package com.Backend.HarvestMaster.Order.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryRequest {
    @JsonProperty("delivery_id")
    private Long deliveryId;

    @JsonProperty("delivery_address")
    private String deliveryAddress;

    @JsonProperty("pickup_address")
    private String pickupAddress;
}
