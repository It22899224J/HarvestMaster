package com.Backend.HarvestMaster.PreHarvest.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PreHarvestPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String startDate;
    private String city;
    private String district;
    private String cropSeason;
    private String fieldPreparation;
    private float area;
    private String sowingMethod;
    private int plantAmount;
    private int seedAmount;
    private String riceVariety;
    private String fertilizerType;
    private int initialExpectedYield;
    private String harvestTime;
}
