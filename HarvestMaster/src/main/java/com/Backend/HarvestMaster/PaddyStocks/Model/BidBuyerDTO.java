package com.Backend.HarvestMaster.PaddyStocks.Model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter
@Setter
public class BidBuyerDTO {

    private int bidid;

    private float price;

    private String buyer_email;

    private String buyer_name;


    private LocalDate creationDate;


    private PaddyStockViewDTO paddyStockViewDTO;

    public BidBuyerDTO() {
    }




}
