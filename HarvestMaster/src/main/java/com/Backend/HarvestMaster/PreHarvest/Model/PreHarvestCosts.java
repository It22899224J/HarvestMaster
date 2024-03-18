package com.Backend.HarvestMaster.PreHarvest.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PreHarvestCosts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int costId;
    private String description;
    private float amount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_id")
    @JsonIgnoreProperties("preHarvestCosts")
    private PreHarvestPlans preHarvestPlans;

    public PreHarvestCosts() {
    }
}
