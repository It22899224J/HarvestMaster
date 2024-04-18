package com.Backend.HarvestMaster.PostHarvest.Model;

public interface PostHarvestAuditProjection {

    int getAuditId();
    int getNo_bags();
    float getWeight();
    float getQualityValue();
    int getNumHarvesting();
    float getFuel();
    float getHarvestingExpense();
    float getTransportExpense();
    float getIncome();
}
