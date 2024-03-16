package com.Backend.HarvestMaster.PaddyStocks.Service;

import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStock;
import com.Backend.HarvestMaster.PaddyStocks.Repository.PaddyStockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaddyStockImpl implements PaddyStockService{


    private PaddyStockRepository paddyStockRepository;
    @Override
    public PaddyStock getPaddyStockDetails(int paddystock_id) {


        return paddyStockRepository.findById(paddystock_id).get();
    }

    @Override
    public List<PaddyStock> getAllPaddyStockDetails() {
        return paddyStockRepository.findAll();
    }

    @Override
    public boolean deletePaddyStock() {
        return false;
    }

    @Override
    public PaddyStock addPaddyStock(PaddyStock paddyStock) {
        return null;
    }
}
