package com.mic.weather.model;

import java.util.Set;

public class CityWeather {

    private String cityName;
    private Set<Weather> cityWeather;

    public CityWeather(String cityName, Set<Weather> cityWeather) {
        this.cityName = cityName;
        this.cityWeather = cityWeather;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    public Set<Weather> getCityWeather() {
        return cityWeather;
    }

    public void setCityWeather(Set<Weather> cityWeather) {
        this.cityWeather = cityWeather;
    }
}
