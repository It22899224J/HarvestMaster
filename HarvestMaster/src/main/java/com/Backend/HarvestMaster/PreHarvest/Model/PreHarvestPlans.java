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
    private int fieldId; // Unique identifier for the pre-harvest plan

    private int farmerId;// ID of the farmer associated with the plan

    private String regNumber; // Registration number of the field
    private String province; //Province where the field is located
    private String district; // District where the field is located
    private String city; // City where the field is located
    private float fieldArea; // Area of the field in acres
    private String riceVariety; // Variety of rice being grown
    private String cropSeason; // Season in which the crop is planted
    private String plantingMethod; // Method used for planting the crop
    private boolean agreed; // Whether the farmer is agreed to the T&C
    private float seedsAmount; // Amount of seeds used for planting
    private float initialExpectedYield; // Initial expected yield of the crop
    private String plantingDate; // Date when the crop was planted
    private String harvestTime; // Time of harvest for the crop

    public PreHarvestPlans() {
    }
}
