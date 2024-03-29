package com.Backend.HarvestMaster.WeatherAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherModel {

    private City city;
    private List<Forecast> list;

    public WeatherModel() {
    }
}
