package com.Backend.HarvestMaster.PostHarvest.Repository;

import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvestTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostHarvestTaskRepository extends JpaRepository<PostHarvestTask,Integer> {
}
