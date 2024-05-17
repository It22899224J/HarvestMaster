package com.Backend.HarvestMaster.PreHarvest.Model.Projections;

public interface PreHarvestCostProjection {
        int getCostId();
        String getDate();
        String getType();
        String getDescription();
        float getAmount();

}
