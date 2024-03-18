package com.Backend.HarvestMaster.PreHarvest.Repository;

import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestCosts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreHarvestCostsRepository extends JpaRepository<PreHarvestCosts, Integer> {
    List<PreHarvestCosts> getAllCostsByFieldId(Integer fieldId);
}
