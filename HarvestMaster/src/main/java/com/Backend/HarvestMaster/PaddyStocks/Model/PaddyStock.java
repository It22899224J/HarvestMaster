package com.Backend.HarvestMaster.PaddyStocks.Model;

import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvestAudit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;

@Entity
@Getter
@Setter
public class PaddyStock {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ps_id;

@Lob
    private Blob image;
    //foreign key for postharvestAudit
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "related_postharvest_auditId")
    private PostHarvestAudit relatedPostHarvestaudit;
    public int amount;
    private float price;
    @Enumerated(EnumType.STRING)
    private Status_stock status;







}
