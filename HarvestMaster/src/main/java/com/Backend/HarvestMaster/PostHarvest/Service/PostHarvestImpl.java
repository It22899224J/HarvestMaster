package com.Backend.HarvestMaster.PostHarvest.Service;


import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import com.Backend.HarvestMaster.PostHarvest.Repository.PostHarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostHarvestImpl implements PostHarvestService{

    @Autowired
    private PostHarvestRepository postHarvestRepository;
    @Override
    public PostHarvest getPostHarvestDetails(Integer field_id) {

        return postHarvestRepository.findById(field_id).get();

    }

    @Override
    public List<PostHarvest> getPostHarvestPlans(Integer farmer) {


        return postHarvestRepository.findByfarmer(farmer);

    }

    @Override
    @Async
    public boolean deletePostHarvestPlan(Integer field_id) {

        postHarvestRepository.deleteById(field_id);
        return true;
    }

    @Override
    public PostHarvest addPostHarvestPlans(PostHarvest postHarvest) {


        return postHarvestRepository.save(postHarvest);
    }

    @Override
    public PostHarvest updatePostHarvestDetails(Integer field_id, PostHarvest postHarvest) {

        postHarvest.setFieldId(field_id);

        return postHarvestRepository.save(postHarvest);
    }
}
