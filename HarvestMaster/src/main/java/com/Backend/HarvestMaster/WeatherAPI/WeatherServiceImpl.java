package com.Backend.HarvestMaster.WeatherAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Override

    public WeatherModel getWeather(String zip) {

        String url = "http://api.openweathermap.org/data/2.5/forecast?zip="+zip+",lk&appid=ddb64a174007a68a4edc85f09f65f2e6&units=metric";

        WebClient.Builder builder = WebClient.builder();


//Weather API invoke
        String jsonString = builder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();




        // Initialize ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Deserialize JSON string into WeatherResponse object
        WeatherModel weatherresponse = null;
        try {
            weatherresponse = objectMapper.readValue(jsonString, WeatherModel.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return weatherresponse;
    }
}
