package com.Backend.HarvestMaster.PreHarvest.Model.Projections;

public interface PreHarvestFieldVisitProjection {
    int getFieldObservationId();
    String getObservationType();
    String getObservationDate();
    float getAffectedArea();
    String getFieldVisitDate();
    String getFieldVisitTime();
    boolean getVisited();
    String getRequestStatus();
}
