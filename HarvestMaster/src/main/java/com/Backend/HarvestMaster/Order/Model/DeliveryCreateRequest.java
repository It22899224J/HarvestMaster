package com.Backend.HarvestMaster.Order.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryCreateRequest {
    @JsonProperty("order_id")
    private int orderId;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("delivery_address")
    private String deliveryAddress;

    @JsonProperty("pickup_address")
    private String pickupAddress;

    @JsonProperty("delivery_date")
    private String deliveryDate;

    @JsonProperty("driver_name")
    private String driverName;

    @JsonProperty("driver_id")
    private String driverId;

    @JsonProperty("vehicle_number")
    private String vehicleNumber;
}
