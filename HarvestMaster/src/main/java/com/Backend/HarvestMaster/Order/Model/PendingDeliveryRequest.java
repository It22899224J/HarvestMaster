package com.Backend.HarvestMaster.Order.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PendingDeliveryRequest {
    @JsonProperty("order_Status")
    private String orderStatus;
    @JsonProperty("payment_status")
    private String paymentStatus;
}
