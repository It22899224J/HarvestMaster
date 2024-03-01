package com.Backend.HarvestMaster.PostHarvest.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PostHarvest

{

    @Id
    private String userName;

    private String fieldName;
    private String paddyVareity;

    private float area;


}
