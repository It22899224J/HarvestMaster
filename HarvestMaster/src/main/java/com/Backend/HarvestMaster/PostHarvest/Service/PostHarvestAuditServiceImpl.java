package com.Backend.HarvestMaster.PostHarvest.Service;

import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvestAudit;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvestAuditProjection;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvestPlan;
import com.Backend.HarvestMaster.PostHarvest.Repository.PostharvestAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostHarvestAuditServiceImpl implements PostHarvestAuditService{


    @Autowired
    private PostharvestAuditRepository postharvestAuditRepository;
    @Autowired
    private PostHarvestService postHarvestService;
    @Override
    public PostHarvestAudit addAudit(Integer fieldId) {

        Optional<PostHarvest> optionalPostHarvest = Optional.ofNullable(postHarvestService.getPostHarvestDetails(fieldId));
        if (optionalPostHarvest.isPresent()) {
           PostHarvest postHarvest = optionalPostHarvest.get();


          Optional<PostHarvestAudit> optionalPostHarvestAudit = Optional.ofNullable(postharvestAuditRepository.findByPostHarvestId(postHarvest.getFieldId()));

          if(optionalPostHarvestAudit.isPresent()){

              PostHarvestAudit currentpostHarvestAudit = optionalPostHarvestAudit.get();

              return currentpostHarvestAudit;
          }
          else{
              // Set the relevant PostHarvest field in the new PaddyStock object
              PostHarvestAudit postHarvestAudit = new PostHarvestAudit();
              postHarvestAudit.setRelatedpostHarvest(postHarvest);
              // Save the new audit
              postharvestAuditRepository.save(postHarvestAudit);

              return  postharvestAuditRepository.save(postHarvestAudit);
          }









        } else {
            // Handle the case when the PostHarvest entity is not found
            throw new RuntimeException("PostHarvest with fieldId " + fieldId + " not found.");

        }

    }

    @Override
    public PostHarvestAuditProjection getAudit(Integer id) {

        return postharvestAuditRepository.findByRelatedPostHarvest_Field_Id(id);


    }

    @Override
    public PostHarvestAudit getAuditData(Integer id) {
        return postharvestAuditRepository.findById(id).get();
    }

    @Override
    public PostHarvestAuditProjection updateAudit(PostHarvestAudit postHarvestAudit) {




      PostHarvestAudit updated = postharvestAuditRepository.save(postHarvestAudit);

      return postharvestAuditRepository.findByRelatedPostHarvest_Field_Id(updated.getRelatedpostHarvest().getFieldId());
    }
}
