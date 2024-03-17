package com.Backend.HarvestMaster.PreHarvest.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private int seedsAmount;
    private String riceVariety;
    private int initialExpectedYield;
    private String startDate;
    private String harvestTime;

    public PreHarvestPlans() {
    }
}
