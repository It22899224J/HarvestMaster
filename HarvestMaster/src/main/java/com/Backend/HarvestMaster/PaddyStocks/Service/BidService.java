package com.Backend.HarvestMaster.PaddyStocks.Service;

import com.Backend.HarvestMaster.PaddyStocks.Model.Bid;

import java.util.List;

public interface BidService {


    public Bid addBid(Bid bid);
    public List<Bid> getAllBids(Integer stock_id);
    public Bid getBid(Integer bid_id);

    public Bid updateBid(Integer bid_id,Bid bid);

    public boolean deleteBid(Integer bid_id);
}
