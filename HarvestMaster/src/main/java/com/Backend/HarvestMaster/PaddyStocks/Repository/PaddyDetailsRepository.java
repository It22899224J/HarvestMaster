package com.Backend.HarvestMaster.PaddyStocks.Repository;
import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStock;
import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStockDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaddyDetailsRepository extends JpaRepository<PaddyStock, Long> {

}
