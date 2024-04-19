package com.Backend.HarvestMaster.PostHarvest.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PostHarvestAudit {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auditId;



    private int no_bags;
    private float weight;
    private float quality_value;

    private int num_harvesting;

    private float fuel;

    private float harvesting_expense;
    private float transport_expense;

    private float income;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "related_postharvest_Id")
    private PostHarvest relatedpostHarvest;


}
