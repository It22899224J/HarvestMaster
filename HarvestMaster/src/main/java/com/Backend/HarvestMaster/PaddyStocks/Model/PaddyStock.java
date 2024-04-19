package com.Backend.HarvestMaster.PaddyStocks.Model;

import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvestAudit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Blob;
import java.time.LocalDate;

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
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "related_postharvest_auditId")
    private PostHarvestAudit relatedPostHarvestaudit;
    public int amount;

    private float price;
    @Enumerated(EnumType.STRING)
    private Status_stock status;
    @CreationTimestamp
    @Column(name = "stockCreationDate", updatable = false)
    private LocalDate stockCreationDate;







}
