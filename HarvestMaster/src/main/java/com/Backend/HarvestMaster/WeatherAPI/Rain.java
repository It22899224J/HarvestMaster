package com.Backend.HarvestMaster.WeatherAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rain {
    private double h3;

    public Rain() {
    }
}
