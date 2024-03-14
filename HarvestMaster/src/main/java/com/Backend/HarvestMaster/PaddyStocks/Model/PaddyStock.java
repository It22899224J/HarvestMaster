package com.Backend.HarvestMaster.PaddyStocks.Model;

import jakarta.persistence.*;

@Entity
public class PaddyStock {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ps_id;

    @Column(nullable = false,name = "postharvest_id")
    private int postharvest_id;

    private float start_value;

    private boolean status;


    public PaddyStock() {
    }
    public int getPs_id() {
        return ps_id;
    }

    public void setPs_id(int ps_id) {
        this.ps_id = ps_id;
    }

    public int getPostharvest_id() {
        return postharvest_id;
    }

    public void setPostharvest_id(int postharvest_id) {
        this.postharvest_id = postharvest_id;
    }

    public float getStart_value() {
        return start_value;
    }

    public void setStart_value(float start_value) {
        this.start_value = start_value;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
