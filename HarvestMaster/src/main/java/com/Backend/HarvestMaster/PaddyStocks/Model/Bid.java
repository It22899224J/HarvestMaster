package com.Backend.HarvestMaster.PaddyStocks.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Bid {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bidid;

    private float price;

    private String buyer_email;

    private String buyer_name;

    private int stockid;

    @CreationTimestamp
    @Column(name = "creation_date", updatable = false)
    private LocalDate creationDate;


    @Enumerated(EnumType.STRING)
    private Status_bid status;
    public Bid() {
    }
}
