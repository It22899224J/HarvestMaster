package com.Backend.HarvestMaster.PaddyStocks.Controller;


import com.Backend.HarvestMaster.PaddyStocks.Service.PaddyStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paddystock")
public class PaddyStockController {


    @Autowired
    private PaddyStockService paddyStockService;







}
