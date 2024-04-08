package com.Backend.HarvestMaster.WeatherAPI;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
    public class CurrentWeather {
        private Coord coord;
        private Weather[] weather;
        private String base;
        private Main main;
        private int visibility;
        private Wind wind;
        private Clouds clouds;
        private long dt;
        private Sys sys;
        private int timezone;
        private int id;
        private String name;
        private int cod;

        // Nested classes for sub arrays of weather data input

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Coord {
            private float lon;
            private float lat;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Weather {

            private String description;
            private String icon;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Main {
            private float temp;
            private float feels_like;
            private float temp_min;
            private float temp_max;
            private int pressure;
            private int humidity;
//            private int sea_level;
//            private int grnd_level;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Wind {
            private float speed;
            private int deg;
            private float gust;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Clouds {
            private int all;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Sys {
            private String country;
            private long sunrise;
            private long sunset;
        }
    }



