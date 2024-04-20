package com.Backend.HarvestMaster.PreHarvest.Repository;

import com.Backend.HarvestMaster.PreHarvest.Model.Projections.PreHarvestCostProjection;
import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestCosts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PreHarvestCostsRepository extends JpaRepository<PreHarvestCosts, Integer> {
    @Query(value = "SELECT cost_id As costId, amount As amount, date As date, description As description, type As type, field_id As fieldId FROM pre_harvest_costs  WHERE field_id = ?1", nativeQuery = true)
    List<PreHarvestCostProjection> findAllProjected(Integer field_id);
}
