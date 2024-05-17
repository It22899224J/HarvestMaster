package com.Backend.HarvestMaster.PaddyStocks.Service;

import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStock;
import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStockAvl;
import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStockDTO;
import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStockViewDTO;

import java.util.List;

public interface PaddyStockService {


    public List<PaddyStockViewDTO> getPaddyStockDetails(int stock_id);

    public PaddyStock getPaddyStock(int stockid);

    public List<PaddyStockAvl>  getPaddyStocksByType(String vareity,String fertilizer);

    public List<PaddyStockDTO> getAllPaddyStockDetails();

    public boolean deletePaddyStock(int paddystock_id);

    public PaddyStockViewDTO updateStock(int paddystock_id,PaddyStock paddyStock);


    public PaddyStockViewDTO addPaddyStock(Integer fieldId,PaddyStock paddyStock);







}
