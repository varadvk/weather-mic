package com.mic.weather.service;

import com.mic.weather.model.CityWeather;
import com.mic.weather.model.CountryWeather;
import com.mic.weather.model.Weather;
import com.mic.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    public Set<CountryWeather> getWeather() {
        return weatherRepository.getWeather();
    }

    public CountryWeather getWeatherByCountry(String countryName) {
        return weatherRepository.getWeatherByCountry(countryName);
    }

    public Set<CityWeather> getTodayWeatherByCountry(String countryName) {
        return weatherRepository.getTodayWeatherByCountry(countryName);
    }

    public CityWeather getWeatherByCity(String cityName) {
        return weatherRepository.getWeatherByCity(cityName);
    }

    public Weather getTodayWeatherByCity(String cityName) {
        return weatherRepository.getTodayWeatherByCity(cityName);
    }
}
