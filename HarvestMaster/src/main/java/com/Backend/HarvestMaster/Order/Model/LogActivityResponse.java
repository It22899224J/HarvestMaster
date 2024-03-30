package com.Backend.HarvestMaster.Order.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LogActivityResponse {
    private String date;
    private String time;
    private String detail;
    @JsonProperty("cart_id")
    private Integer cartId;
}
