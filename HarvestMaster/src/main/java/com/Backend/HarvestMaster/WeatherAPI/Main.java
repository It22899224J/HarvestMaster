package com.Backend.HarvestMaster.WeatherAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
    private double temp;
    private double feels_like;

    private int pressure;

    private int humidity;


    public Main() {
    }

    // Getters and Setters
}