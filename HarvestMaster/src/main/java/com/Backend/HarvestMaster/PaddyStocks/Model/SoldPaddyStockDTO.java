package com.Backend.HarvestMaster.PaddyStocks.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SoldPaddyStockDTO {


    private int soldstockid;

    private PaddyStockViewDTO releventpaddyStock;


    private Bid acceptedbid;

    private  String transportstatus;
    private String paymentstatus;
    private String pickuplocation;
    private String arrivinglocation;

}
