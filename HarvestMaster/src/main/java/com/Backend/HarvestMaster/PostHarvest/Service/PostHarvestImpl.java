package com.Backend.HarvestMaster.PostHarvest.Service;

import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostHarvestImpl implements PostHarvestService{
    @Override
    public PostHarvest getPostHarvestDetails(Integer fieldId) {
        return null;
    }

    @Override
    public List<PostHarvest> getPostHarvestPlans(Integer farmerId) {
        return null;
    }

    @Override
    public boolean deletePostHarvestPlan(Integer fieldId) {
        return false;
    }

    @Override
    public PostHarvest addPostHarvestPlans(PostHarvest postHarvest) {
        return null;
    }
}
