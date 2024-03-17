package com.Backend.HarvestMaster.PostHarvest.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PostHarvest

{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int field_id;
    private int farmer;

    private String fieldName;
    private String regNo;

    private String paddyVareity;
    private float area;
    private String ownership;



    private String split;
    private String location;
    private float startingPrice;
    private String plantedDate;
    private String harvestDate;

    public PostHarvest() {
    }

    public int getFieldId() {
        return field_id;
    }

    public void setFieldId(int field_id) {
        this.field_id = field_id;
    }

    public int getFarmer_id() {
        return farmer;
    }

    public void setFarmer_id(int farmer) {
        this.farmer = farmer;
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

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getSplit() {
        return split;
    }

    public void setSplit(String split) {
        this.split = split;
    }


}
