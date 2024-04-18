package com.Backend.HarvestMaster.PostHarvest.Service;

import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvestAudit;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvestAuditProjection;

public interface PostHarvestAuditService {


    public PostHarvestAudit addAudit(Integer fieldId);

    public PostHarvestAuditProjection getAudit(Integer id);
    public PostHarvestAudit getAuditData(Integer id);



    public PostHarvestAuditProjection updateAudit(PostHarvestAudit postHarvestAudit);

}
