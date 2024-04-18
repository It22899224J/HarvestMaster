package com.Backend.HarvestMaster.PostHarvest.Repository;

import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStock;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvestAudit;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvestAuditProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostharvestAuditRepository extends JpaRepository<PostHarvestAudit,Integer> {

    @Query(value = "SELECT "+"a.audit_id AS auditId, " +
            "a.no_bags AS no_bags, " +
            "a.weight AS weight, " +
            "a.quality_value AS qualityValue, " +
            "a.num_harvesting AS numHarvesting, " +
            "a.fuel AS fuel, " +
            "a.harvesting_expense AS harvestingExpense, " +
            "a.transport_expense AS transportExpense, " +
            "a.income AS income " +" FROM post_harvest_audit a JOIN  post_harvest p  ON a.related_postharvest_id=p.field_id WHERE  p.field_id=?1  ",nativeQuery = true)
    PostHarvestAuditProjection findByRelatedPostHarvest_Field_Id(int fieldId);

    @Query(value = "SELECT * FROM post_harvest_audit WHERE related_postharvest_id=?1",nativeQuery = true)
    PostHarvestAudit findByPostHarvestId(int fieldId);

}
