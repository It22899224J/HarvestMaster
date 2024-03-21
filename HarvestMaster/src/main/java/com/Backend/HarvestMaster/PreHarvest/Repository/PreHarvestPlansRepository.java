package com.Backend.HarvestMaster.PreHarvest.Repository;

import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreHarvestPlansRepository extends JpaRepository<PreHarvestPlans,Integer> {
    List<PreHarvestPlans> findByFarmerId(Integer farmerId);
}
