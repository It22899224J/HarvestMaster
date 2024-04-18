package com.Backend.HarvestMaster.PaddyStocks.Model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class PaddyStockAvl {

    private float price;


    public PaddyStockAvl() {
    }

    public PaddyStockAvl(float price) {
        this.price = price;
    }
}
