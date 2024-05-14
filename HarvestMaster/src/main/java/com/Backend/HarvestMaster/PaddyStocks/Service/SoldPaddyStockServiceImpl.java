package com.Backend.HarvestMaster.PaddyStocks.Service;

import com.Backend.HarvestMaster.PaddyStocks.Model.*;
import com.Backend.HarvestMaster.PaddyStocks.Repository.SoldPaddyStockrepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SoldPaddyStockServiceImpl implements SoldPaddyStockService{

    @Autowired
    private SoldPaddyStockrepsitory soldPaddyStockrepsitory;
    @Autowired
    private BidService bidService;

    @Autowired
    private PaddyStockService paddyStockService;

    @Override
    public SoldPaddyStock addSoldPaddyStock(Integer stockid, Integer acceptedBid) {



            if (acceptedBid != 0 && stockid!=0) {


                SoldPaddyStock newSoldStock = new SoldPaddyStock();
                newSoldStock.setAcceptedbid(bidService.getBid(acceptedBid));
                PaddyStock available = paddyStockService.getPaddyStock(stockid);
                newSoldStock.setReleventpaddyStock(available);

                available.setStatus(Status_stock.CLOSED);
                paddyStockService.updateStock(available.getPs_id(), available);
                return soldPaddyStockrepsitory.save(newSoldStock);

            }


        return null;
    }

    @Override
    public SoldPaddyStockDTO updateSoldPaddyStock(Integer id, SoldPaddyStock soldPaddyStock) {

        SoldPaddyStock existingSoldPaddyStock = soldPaddyStockrepsitory.findById(id).get();

        if (existingSoldPaddyStock == null) {
            // Handle the case where the SoldPaddyStock entity with the given ID doesn't exist
            // You may throw an exception or handle it based on your requirements
            return null;
        }

        // Update only the fields with non-null values from the incoming object


        if (soldPaddyStock.getTransportstatus() != null) {
            existingSoldPaddyStock.setTransportstatus(soldPaddyStock.getTransportstatus());
        }
        if (soldPaddyStock.getPaymentstatus() != null) {
            existingSoldPaddyStock.setPaymentstatus(soldPaddyStock.getPaymentstatus());
        }
        if (soldPaddyStock.getPickuplocation() != null) {
            existingSoldPaddyStock.setPickuplocation(soldPaddyStock.getPickuplocation());
        }
        if (soldPaddyStock.getArrivinglocation() != null) {
            existingSoldPaddyStock.setArrivinglocation(soldPaddyStock.getArrivinglocation());
        }

        // Save the updated SoldPaddyStock entity using the repository
        SoldPaddyStock udpatedstock = soldPaddyStockrepsitory.save(existingSoldPaddyStock);

        SoldPaddyStockDTO soldPaddyStockDTO = new SoldPaddyStockDTO();

        soldPaddyStockDTO.setAcceptedbid(udpatedstock.getAcceptedbid());
        soldPaddyStockDTO.setReleventpaddyStock(paddyStockService.getPaddyStockDetails(udpatedstock.getReleventpaddyStock().getPs_id()).get(0));

        soldPaddyStockDTO.setArrivinglocation(udpatedstock.getArrivinglocation());
        soldPaddyStockDTO.setPaymentstatus(udpatedstock.getPaymentstatus());
        soldPaddyStockDTO.setSoldstockid(udpatedstock.getSoldstockid());
        soldPaddyStockDTO.setTransportstatus(udpatedstock.getTransportstatus());


        return  soldPaddyStockDTO;

    }

    @Override
    public boolean removeSoldPaddystock(Integer sStockid) {

        soldPaddyStockrepsitory.deleteById(sStockid);

        return true;
    }

    @Override
    public SoldPaddyStockDTO getSoldPaddyStock(Integer stock_id) {
        int soldStockId = soldPaddyStockrepsitory.findByIdStockId(stock_id);

        Optional<SoldPaddyStock> currentResult = soldPaddyStockrepsitory.findById(soldStockId);
        SoldPaddyStockDTO soldPaddyStockDTO = new SoldPaddyStockDTO();
        if(currentResult.isPresent()) {
           SoldPaddyStock current  = currentResult.get();



            soldPaddyStockDTO.setAcceptedbid(current.getAcceptedbid());
            soldPaddyStockDTO.setReleventpaddyStock(paddyStockService.getPaddyStockDetails(stock_id).get(0));

            soldPaddyStockDTO.setArrivinglocation(current.getArrivinglocation());
            soldPaddyStockDTO.setPaymentstatus(current.getPaymentstatus());
            soldPaddyStockDTO.setSoldstockid(current.getSoldstockid());
            soldPaddyStockDTO.setTransportstatus(current.getTransportstatus());


        }
        return soldPaddyStockDTO;

    }

    @Override
    public SoldPaddyStockDTO getSoldPaddyStocksBuyer(String buyer_name) {

        int soldStockId = soldPaddyStockrepsitory.findByBuyernames(buyer_name);

        Optional<SoldPaddyStock> currentResult = soldPaddyStockrepsitory.findById(soldStockId);
        SoldPaddyStockDTO soldPaddyStockDTO = new SoldPaddyStockDTO();
        if(currentResult.isPresent()) {
            SoldPaddyStock current  = currentResult.get();



            soldPaddyStockDTO.setAcceptedbid(current.getAcceptedbid());
            soldPaddyStockDTO.setReleventpaddyStock(paddyStockService.getPaddyStockDetails(current.getReleventpaddyStock().getPs_id()).get(0));

            soldPaddyStockDTO.setArrivinglocation(current.getArrivinglocation());
            soldPaddyStockDTO.setPaymentstatus(current.getPaymentstatus());
            soldPaddyStockDTO.setSoldstockid(current.getSoldstockid());
            soldPaddyStockDTO.setTransportstatus(current.getTransportstatus());


        }
        return soldPaddyStockDTO;

    }
}
