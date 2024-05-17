package com.Backend.HarvestMaster.PaddyStocks.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SoldPaddyStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int soldstockid;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "related_paddystock")
    private PaddyStock releventpaddyStock;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "related_bid")
    private Bid acceptedbid;

    private  String transportstatus;
    private String paymentstatus;
    private String pickuplocation;
    private String arrivinglocation;

}
