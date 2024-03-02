package com.Backend.HarvestMaster.PostHarvest.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PostHarvest

{
    @Id
    private int fieldId;
    private String farmerId;

    private String fieldName;
    private String paddyVareity;
    private float area;
    private String ownership;
    private String location;
    private float startingPrice;
    private String plantedDate;
    private String harvestDate;

    public PostHarvest() {
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getPaddyVareity() {
        return paddyVareity;
    }

    public void setPaddyVareity(String paddyVareity) {
        this.paddyVareity = paddyVareity;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(float startingPrice) {
        this.startingPrice = startingPrice;
    }

    public String getPlantedDate() {
        return plantedDate;
    }

    public void setPlantedDate(String plantedDate) {
        this.plantedDate = plantedDate;
    }

    public String getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(String harvestDate) {
        this.harvestDate = harvestDate;
    }




}
