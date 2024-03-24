package com.Backend.HarvestMaster.PaddyStocks.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bid {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bid_id;

    private float price;

    private String buyer_email;

    private String buyer_name;

    private int stockid;

    @Enumerated(EnumType.STRING)
    private Status_bid status;
    public Bid() {
    }
}
