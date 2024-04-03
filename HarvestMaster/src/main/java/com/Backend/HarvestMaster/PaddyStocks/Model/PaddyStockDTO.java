package com.Backend.HarvestMaster.PaddyStocks.Model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaddyStockDTO {

    private int ps_id;
    private String imageBase64;
    private int amount;
    private float price;
    private Status_stock status;
    private String paddyVariety;
    private String location;
    private List<BidDTO> bids;

    public PaddyStockDTO() {
    }

    // Constructors, getters, and setters
}