package com.Backend.HarvestMaster.PreHarvest.Service;

import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestFieldVisits;
import com.Backend.HarvestMaster.PreHarvest.Model.Projections.PreHarvestFieldVisitProjection;

import java.util.List;

public interface PreHarvestFieldVisitsService {
    PreHarvestFieldVisits addFieldVisit(PreHarvestFieldVisits preHarvestFieldVisits);
    List<PreHarvestFieldVisitProjection> getAllFieldVisits(Integer fieldId);
    PreHarvestFieldVisits getFieldVisitById(Integer fieldObservationId);
    PreHarvestFieldVisits updateFieldVisits(Integer observationId, PreHarvestFieldVisits preHarvestFieldVisits);
    boolean deleteFieldVisit (Integer observationId);

}
