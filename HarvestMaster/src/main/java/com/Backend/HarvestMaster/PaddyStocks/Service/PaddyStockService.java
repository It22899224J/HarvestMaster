package com.Backend.HarvestMaster.PaddyStocks.Service;

import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStock;

import java.util.List;

public interface PaddyStockService {


    public PaddyStock getPaddyStockDetails(int paddystock_id);

    public List<PaddyStock> getAllPaddyStockDetails();

    public boolean deletePaddyStock();


    public PaddyStock addPaddyStock(PaddyStock paddyStock);





}
