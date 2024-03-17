package com.Backend.HarvestMaster.PreHarvest.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
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

    public int getFieldId() {
        return fieldId;
    }
    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public int getFarmerId() {
        return farmerId;
    }
    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getCropSeason() {
        return cropSeason;
    }
    public void setCropSeason(String cropSeason) {
        this.cropSeason = cropSeason;
    }

    public float getFieldArea() {
        return fieldArea;
    }
    public void setFieldArea(float fieldArea) {
        this.fieldArea = fieldArea;
    }

    public String getPlantingMethod() {
        return plantingMethod;
    }
    public void setPlantingMethod(String plantingMethod) {
        this.plantingMethod = plantingMethod;
    }

    public int getSeedsAmount() {
        return seedsAmount;
    }
    public void setSeedsAmount(int seedsAmount) {
        this.seedsAmount = seedsAmount;
    }

    public String getRiceVariety() {
        return riceVariety;
    }
    public void setRiceVariety(String riceVariety) {
        this.riceVariety = riceVariety;
    }

    public int getInitialExpectedYield() {
        return initialExpectedYield;
    }
    public void setInitialExpectedYield(int initialExpectedYield) {
        this.initialExpectedYield = initialExpectedYield;
    }

    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getHarvestTime() {
        return harvestTime;
    }
    public void setHarvestTime(String harvestTime) {
        this.harvestTime = harvestTime;
    }


}
