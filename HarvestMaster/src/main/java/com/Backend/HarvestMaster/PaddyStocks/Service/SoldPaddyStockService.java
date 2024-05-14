package com.Backend.HarvestMaster.PaddyStocks.Service;

import com.Backend.HarvestMaster.PaddyStocks.Model.Bid;
import com.Backend.HarvestMaster.PaddyStocks.Model.SoldPaddyStock;
import com.Backend.HarvestMaster.PaddyStocks.Model.SoldPaddyStockDTO;

public interface SoldPaddyStockService {


  public SoldPaddyStock addSoldPaddyStock(Integer stockid, Integer bidid);

    public SoldPaddyStockDTO updateSoldPaddyStock(Integer id,SoldPaddyStock soldPaddyStock);

    public boolean removeSoldPaddystock(Integer sStockid);

    public SoldPaddyStockDTO getSoldPaddyStock(Integer stock_id);

  public SoldPaddyStockDTO getSoldPaddyStocksBuyer(String buyer_name);


}
