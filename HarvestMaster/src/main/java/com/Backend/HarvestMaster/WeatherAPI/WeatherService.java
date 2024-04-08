package com.Backend.HarvestMaster.WeatherAPI;

public interface WeatherService {

    public WeatherModel getWeather(String zip);

    public CurrentWeather getCurrentWeather(String zip);
}
