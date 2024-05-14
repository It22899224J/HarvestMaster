package com.Backend.HarvestMaster.PaddyStocks.Model;

import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvestAudit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;
import java.time.LocalDate;

//for the details page
@Getter
@Setter
public class PaddyStockViewDTO {
    private int ps_id;


    private String image;
    //foreign key for postharvest

    private int relatedPostHarvestaudit;
    public int amount;
    private float price;
    @Enumerated(EnumType.STRING)
    private Status_stock status;
    private LocalDate stockCreationDate;

}
