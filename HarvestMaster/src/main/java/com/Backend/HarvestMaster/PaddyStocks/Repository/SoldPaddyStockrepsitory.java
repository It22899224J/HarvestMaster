package com.Backend.HarvestMaster.PaddyStocks.Repository;

import com.Backend.HarvestMaster.PaddyStocks.Model.SoldPaddyStock;
import jakarta.persistence.Index;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SoldPaddyStockrepsitory extends JpaRepository<SoldPaddyStock,Integer> {



    @Query(value = "SELECT s.soldstockid FROM sold_paddy_stock  s JOIN paddy_stock p ON s.related_paddystock = p.ps_id " ,nativeQuery = true)
    Integer findByIdStockId(Integer stockId);
}
