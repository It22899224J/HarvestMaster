package com.Backend.HarvestMaster.PaddyStocks.Repository;

import com.Backend.HarvestMaster.PaddyStocks.Model.Bid;
import com.Backend.HarvestMaster.PaddyStocks.Model.BidDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BidsRepository extends JpaRepository<Bid,Integer> {
    List<Bid> findAllBystockid(Integer stockId);

    List<BidDTO> findAllbidsBystockid(Integer stockId);


    @Query(value = "SELECT * FROM bid   WHERE  buyer_name=?1  ",nativeQuery = true)
    List<Bid> getBidsByBuyerName(String buyer);
}
