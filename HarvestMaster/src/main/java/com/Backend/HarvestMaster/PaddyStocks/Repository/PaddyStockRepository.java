package com.Backend.HarvestMaster.PaddyStocks.Repository;

import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface PaddyStockRepository extends JpaRepository<PaddyStock,Integer> {


    List<PaddyStock> findByRelatedPostHarvest_FieldId(int fieldId);
}
