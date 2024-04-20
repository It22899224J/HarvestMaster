package com.Backend.HarvestMaster.PreHarvest.Model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreHarvestFieldVisit {

    private String observationType;
    private String observationDate;
    private float affectedArea;
    private String fieldVisitDate;
    private String fieldVisitTime;
    private boolean visited;
    private String requestStatus;
    public  PreHarvestFieldVisit(){
    }
}
