package com.Backend.HarvestMaster.PostHarvest.Service;


import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvestPlan;
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
    public List<PostHarvestPlan> getPostHarvestPlans(Integer farmer) {


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
    public PostHarvest updatePostHarvestDetails(Integer field_id, PostHarvest newPostHarvest) {

        PostHarvest existingPostHarvest = getPostHarvestDetails(field_id);


        if (newPostHarvest.getFieldName() != null && !newPostHarvest.getFieldName().isEmpty()) {
            existingPostHarvest.setFieldName(newPostHarvest.getFieldName());
        }

        // Registration Number
        if (newPostHarvest.getRegNo() != null && !newPostHarvest.getRegNo().isEmpty()) {
            existingPostHarvest.setRegNo(newPostHarvest.getRegNo());
        }

        // Paddy Variety
        if (newPostHarvest.getPaddyVareity() != null && !newPostHarvest.getPaddyVareity().isEmpty()) {
            existingPostHarvest.setPaddyVareity(newPostHarvest.getPaddyVareity());
        }

        // Area
        if (newPostHarvest.getArea() > 0) {
            existingPostHarvest.setArea(newPostHarvest.getArea());
        }

        // Zip Code
        if (newPostHarvest.getZip() > 0) {
            existingPostHarvest.setZip(newPostHarvest.getZip());
        }

        // Ownership
        if (newPostHarvest.getOwnership() != null && !newPostHarvest.getOwnership().isEmpty()) {
            existingPostHarvest.setOwnership(newPostHarvest.getOwnership());
        }

        // Split
        if (newPostHarvest.getSplit() != null && !newPostHarvest.getSplit().isEmpty()) {
            existingPostHarvest.setSplit(newPostHarvest.getSplit());
        }

        // Location
        if (newPostHarvest.getLocation() != null && !newPostHarvest.getLocation().isEmpty()) {
            existingPostHarvest.setLocation(newPostHarvest.getLocation());
        }

        // Harvest Type
        if (newPostHarvest.getType() != null) {
            existingPostHarvest.setType(newPostHarvest.getType());
        }

        // Planted Date
        if (newPostHarvest.getPlantedDate() != null && !newPostHarvest.getPlantedDate().isEmpty()) {
            existingPostHarvest.setPlantedDate(newPostHarvest.getPlantedDate());
        }

        // Harvest Date
        if (newPostHarvest.getHarvestDate() != null && !newPostHarvest.getHarvestDate().isEmpty()) {
            existingPostHarvest.setHarvestDate(newPostHarvest.getHarvestDate());
        }

        // Bid Status
        if (newPostHarvest.getStatus() != null) {
            existingPostHarvest.setStatus(newPostHarvest.getStatus());
        }

        // Fertilizer Type
        if (newPostHarvest.getFertilizerType() != null && !newPostHarvest.getFertilizerType().isEmpty()) {
            existingPostHarvest.setFertilizerType(newPostHarvest.getFertilizerType());
        }

        // Related Audit
        // Assuming relatedAudit should not be updated here


        return postHarvestRepository.save(existingPostHarvest);
    }
}
