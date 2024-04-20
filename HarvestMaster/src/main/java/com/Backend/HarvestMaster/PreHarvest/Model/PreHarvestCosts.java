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
    private int costId; // Unique identifier for the cost

    private String date; // Date of the cost
    private String type; // Type of cost (e.g., labor, materials)
    private String description; // Description of the cost
    private float amount; // Amount of the cost

    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE}) // Many costs can belong to one pre-harvest plan
    @JoinColumn(name = "field_id") // Name of the foreign key column in the database
    @JsonIgnoreProperties("preHarvestCosts") // Ignore the preHarvestCosts property to avoid infinite recursion
    private PreHarvestPlans preHarvestPlans; // Pre-harvest plan to which the cost belongs

    public PreHarvestCosts() {
    }
}
