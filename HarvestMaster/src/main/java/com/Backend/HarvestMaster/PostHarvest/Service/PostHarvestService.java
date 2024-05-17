package com.Backend.HarvestMaster.PostHarvest.Service;

import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvestPlan;

import java.util.List;

public interface PostHarvestService {

    public PostHarvest getPostHarvestDetails(Integer field_id);

    public List<PostHarvestPlan> getPostHarvestPlans(Integer farmer_id);

    public boolean deletePostHarvestPlan(Integer field_id);

    public PostHarvest addPostHarvestPlans(PostHarvest postHarvest);

    public PostHarvest updatePostHarvestDetails(Integer fieldId,PostHarvest postHarvest);
}
