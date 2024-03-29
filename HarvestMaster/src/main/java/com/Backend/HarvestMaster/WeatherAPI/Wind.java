package com.Backend.HarvestMaster.WeatherAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {
    private double speed;
    private int deg;
    private double gust;

    public Wind() {
    }
}
