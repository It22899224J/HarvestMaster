package com.Backend.HarvestMaster.PaddyStocks.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaddyStockDetails {




    private int ps_id;
    private float price;
    private int amount;


    private String harvestDate;
    private String location;
    private String fertilizerType;
    private String paddyVareity;

    public PaddyStockDetails(int ps_id, float price, int amount, String harvestDate, String location, String fertilizerType, String paddyVareity) {
        this.ps_id = ps_id;
        this.price = price;
        this.amount = amount;
        this.harvestDate = harvestDate;
        this.location = location;
        this.fertilizerType = fertilizerType;
        this.paddyVareity = paddyVareity;
    }

}
