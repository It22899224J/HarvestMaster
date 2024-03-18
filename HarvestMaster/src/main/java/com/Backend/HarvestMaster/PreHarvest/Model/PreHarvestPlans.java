package com.Backend.HarvestMaster.PreHarvest.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PreHarvestPlans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fieldId;
    private int farmerId;
    private String district;
    private String city;
    private String cropSeason;
    private float fieldArea;
    private String plantingMethod;
    private float seedsAmount;
    private String riceVariety;
    private float initialExpectedYield;
    private String plantingDate;
    private String harvestTime;

    @OneToOne(mappedBy = "preHarvestPlans", cascade = CascadeType.ALL, orphanRemoval = true)
    private PreHarvestCosts preHarvestCosts;

    public PreHarvestPlans() {
    }
}
