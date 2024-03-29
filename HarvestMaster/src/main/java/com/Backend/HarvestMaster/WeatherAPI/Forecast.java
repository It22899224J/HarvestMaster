package com.Backend.HarvestMaster.WeatherAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    private long dt;
    private Main main;
    private List<Weather> weather;

    private Wind wind;
    private int visibility;
    private double pop;
    private Rain rain;
    private String dt_txt;

    public Forecast() {
    }

    // Getters and Setters
}