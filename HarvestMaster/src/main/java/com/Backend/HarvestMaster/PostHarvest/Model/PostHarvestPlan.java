package com.Backend.HarvestMaster.PostHarvest.Model;

import java.time.LocalDate;

public interface PostHarvestPlan {

    int getFieldId();
    String getLocation();
    LocalDate getPlantedDate();
    String getFieldName();

    String getPaddyVareity();

    float getArea();

    String getDistrict();

}
