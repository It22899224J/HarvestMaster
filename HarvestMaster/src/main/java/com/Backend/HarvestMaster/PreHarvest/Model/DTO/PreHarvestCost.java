package com.Backend.HarvestMaster.PreHarvest.Model.DTO;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PreHarvestCost {
    private String type;
    private String date;
    private String description;
    private float amount;

    public PreHarvestCost(){
    }
}
