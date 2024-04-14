package com.Backend.HarvestMaster.WeatherAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/postharvest/v1/weather")
public class WeatherController {

@Autowired
private WeatherService weatherService;

    @GetMapping("/forecast/{zip}")
    public ResponseEntity<WeatherModel> getWeatherDetails(@PathVariable String zip){

        try {

            return new ResponseEntity<>(weatherService.getWeather(zip),HttpStatus.OK);

        }catch (NoSuchElementException e){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/current/{zip}")
    public ResponseEntity<CurrentWeather> getCurrentWeatherDetails(@PathVariable String zip){

        try {

            return new ResponseEntity<>(weatherService.getCurrentWeather(zip),HttpStatus.OK);

        }catch (NoSuchElementException e){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
