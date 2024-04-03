package com.Backend.HarvestMaster.PaddyStocks.Repository;

import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStock;
import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStockAvl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface PaddyStockRepository extends JpaRepository<PaddyStock,Integer> {


    List<PaddyStock> findByRelatedPostHarvest_FieldId(int fieldId);


    @Query(value = "SELECT s.price FROM paddy_stock s JOIN post_harvest p ON s.related_postharvest_id=p.field_id  WHERE  p.paddy_vareity=?1 AND p.fertilizer_type=?2 ",nativeQuery = true)
    List<Object[]> findByVareityAndFertilizer(String vareity,String fert);
}
