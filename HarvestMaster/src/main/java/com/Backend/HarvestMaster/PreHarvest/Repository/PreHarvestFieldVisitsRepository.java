package com.Backend.HarvestMaster.PreHarvest.Repository;

import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestFieldVisits;
import com.Backend.HarvestMaster.PreHarvest.Model.Projections.PreHarvestCostProjection;
import com.Backend.HarvestMaster.PreHarvest.Model.Projections.PreHarvestFieldVisitProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PreHarvestFieldVisitsRepository extends JpaRepository<PreHarvestFieldVisits, Integer> {
    @Query(value = "SELECT field_observation_id As fieldObservationId, affected_area As affectedArea, field_visit_date As fieldVisitDate, field_visit_time As fieldVisitTime, observation_date As observationDate, observation_type As observationType, request_status As requestStatus, visited As visited, field_id As fieldId FROM pre_harvest_field_visits WHERE field_id = ?1", nativeQuery = true)
    List<PreHarvestFieldVisitProjection> findAllProjected(Integer field_id);
}
