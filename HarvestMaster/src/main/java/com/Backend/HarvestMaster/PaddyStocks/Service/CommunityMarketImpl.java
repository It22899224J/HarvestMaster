package com.Backend.HarvestMaster.PaddyStocks.Service;

import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStockDetails;
import com.Backend.HarvestMaster.PaddyStocks.Repository.PaddyStockRepository;
import com.Backend.HarvestMaster.PostHarvest.Repository.PostHarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityMarketImpl implements CommunityMarketService{

    @Autowired
    private PaddyStockRepository paddyStockRepository;

    @Autowired
    private PostHarvestRepository postHarvestRepository;


    @Override
    public List<PaddyStockDetails> getAllStocks() {



        return null;
    }
}
