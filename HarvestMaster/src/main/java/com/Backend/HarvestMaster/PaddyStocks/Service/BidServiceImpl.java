package com.Backend.HarvestMaster.PaddyStocks.Service;

import com.Backend.HarvestMaster.PaddyStocks.Model.*;
import com.Backend.HarvestMaster.PaddyStocks.Repository.BidsRepository;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BidServiceImpl implements BidService{


    @Autowired
    private BidsRepository bidsRepository;
    @Override
    public Bid addBid(Bid bid) {
        return bidsRepository.save(bid);
    }

    @Override
    public List<Bid> getAllBids(Integer stock_id) {
        return bidsRepository.findAllBystockid(stock_id);
    }

    @Override
    public Bid getBid(Integer bid_id) {
        return bidsRepository.findById(bid_id).get();
    }

    @Override
    public List<BidDTO> getMarketBids(Integer stock_id) {





        return bidsRepository.findAllbidsBystockid(stock_id);



    }

    @Override
    public Bid updateBid(Integer bid_id, Bid bid) {

        Bid current = bidsRepository.findById(bid_id).get();
        bid.setBid_id(current.getBid_id());
        return bidsRepository.save(bid);
    }

    @Override
    public boolean deleteBid(Integer bid_id) {
        bidsRepository.deleteById(bid_id);
        return true;
    }



//    private BidDTO convertTobidDTO(Bid bid) {
//        BidDTO dto = new BidDTO();
//        dto.setPrice(bid.getPrice());
//        dto.setDate(bid.getCreationDate());
//
//        return dto;
//    }

}
