package com.Backend.HarvestMaster.PostHarvest.Repository;

import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvestPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostHarvestRepository extends JpaRepository<PostHarvest,Integer> {




    List<PostHarvestPlan> findByfarmer(Integer farmer);


}
