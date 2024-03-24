package com.Backend.HarvestMaster.PostHarvest.Repository;

import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostHarvestRepository extends JpaRepository<PostHarvest,Integer> {




    List<PostHarvest> findByfarmer(Integer farmer);


}
