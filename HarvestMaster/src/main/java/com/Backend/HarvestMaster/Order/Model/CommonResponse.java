package com.Backend.HarvestMaster.Order.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommonResponse {
    private String message;
    private boolean status;
    private Object data;
}
