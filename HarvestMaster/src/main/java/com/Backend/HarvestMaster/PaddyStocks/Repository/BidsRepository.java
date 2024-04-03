package com.Backend.HarvestMaster.PaddyStocks.Repository;

import com.Backend.HarvestMaster.PaddyStocks.Model.Bid;
import com.Backend.HarvestMaster.PaddyStocks.Model.BidDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidsRepository extends JpaRepository<Bid,Integer> {
    List<Bid> findAllBystockid(Integer stockId);

    List<BidDTO> findAllbidsBystockid(Integer stockId);
}
