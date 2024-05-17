package com.Backend.HarvestMaster.Order.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManageDeliveryRequest {
    @JsonProperty("delivery_id")
    private Long deliveryId;

    @JsonProperty("status")
    private boolean orderStatus;

    @JsonProperty("payment_status")
    private boolean paymentStatus;

    @JsonProperty("reason")
    private String reason;
}
