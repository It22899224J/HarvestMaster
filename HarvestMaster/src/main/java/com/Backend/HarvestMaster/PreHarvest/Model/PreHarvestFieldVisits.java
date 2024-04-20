package com.Backend.HarvestMaster.PreHarvest.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PreHarvestFieldVisits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fieldObservationId; // Unique identifier for the field observation

    private String observationType; // Type of observation (e.g., pest infestation, disease incidence)
    private String observationDate; // Date of the observation
    private float affectedArea; // Area affected by the observation
    private String fieldVisitDate; // Date of the field visit
    private String fieldVisitTime; // Time of the field visit
    private boolean visited; // Flag indicating whether the field has been visited
    private String requestStatus; // Status of the visit request

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}) // Many field visits can belong to one pre-harvest plan
    @JoinColumn(name = "field_id") // Name of the foreign key column in the database
    @JsonIgnoreProperties("preHarvestFieldVisits") // Ignore the preHarvestFieldVisits property to avoid infinite recursion
    private PreHarvestPlans preHarvestPlans; // Pre-harvest plan to which the field visit belongs

    public  PreHarvestFieldVisits(){

    }
}
