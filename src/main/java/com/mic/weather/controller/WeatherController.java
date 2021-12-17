package com.mic.weather.controller;

import com.mic.weather.model.CityWeather;
import com.mic.weather.model.CountryWeather;
import com.mic.weather.model.Weather;
import com.mic.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public Set<CountryWeather> getWeather() {
        return weatherService.getWeather();
    }

    @GetMapping("/weather/country/{countryName}")
    public CountryWeather getWeatherByCountry(@PathVariable(name = "countryName") String countryName) {
        return weatherService.getWeatherByCountry(countryName);
    }

    @GetMapping("/weather/country/{countryName}/today")
    public Set<CityWeather> getTodayWeatherByCountry(@PathVariable(name = "countryName") String countryName) {
        return weatherService.getTodayWeatherByCountry(countryName);
    }

    @GetMapping("/weather/city/{cityName}")
    public CityWeather getWeatherByCity(@PathVariable(name = "cityName") String cityName) {
        return weatherService.getWeatherByCity(cityName);
    }

    @GetMapping("/weather/city/{cityName}/today")
    public Weather getTodayWeatherByCity(@PathVariable(name = "cityName") String cityName) {
        return weatherService.getTodayWeatherByCity(cityName);
    }

}
