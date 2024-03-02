package com.Backend.HarvestMaster.PostHarvest.Service;

import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;

import java.util.List;

public interface PostHarvestService {

    public PostHarvest getPostHarvestDetails(Integer fieldId);

    public List<PostHarvest> getPostHarvestPlans(Integer farmerId);

    public boolean deletePostHarvestPlan(Integer fieldId);

    public PostHarvest addPostHarvestPlans(PostHarvest postHarvest);
}
