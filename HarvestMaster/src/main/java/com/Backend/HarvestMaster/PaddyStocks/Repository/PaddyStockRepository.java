package com.Backend.HarvestMaster.PaddyStocks.Repository;

import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaddyStockRepository extends JpaRepository<PaddyStock,Integer> {
}
