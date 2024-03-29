package com.Backend.HarvestMaster.PaddyStocks.Model;

import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;

@Getter
@Setter
public class PaddyStockViewDTO {
    private int ps_id;
    private String image;
    //foreign key for postharvest
    @ManyToOne
    @JoinColumn(name = "related_postharvest_id")
    private PostHarvest relatedPostHarvest;
    public int amount;
    private float price;
    @Enumerated(EnumType.STRING)
    private Status_stock status;
}
