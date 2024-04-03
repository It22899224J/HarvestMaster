package com.Backend.HarvestMaster.PostHarvest.Model;


import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStock;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class PostHarvest

{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fieldId;
    private int farmer;

    private String fieldName;
    private String regNo;

    private String paddyVareity;
    private float area;
    private int zip;
    private String ownership;



    private String split;
    private String location;
    private float startingPrice;
    private String plantedDate;
    private String harvestDate;

    @Enumerated(EnumType.STRING)
    private BidStatus status;

    private String fertilizerType;



    public PostHarvest() {
    }



}
