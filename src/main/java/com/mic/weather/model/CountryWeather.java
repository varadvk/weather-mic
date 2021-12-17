package com.mic.weather.model;

import java.util.Set;

public class CountryWeather {

    private String countryName;
    private Set<CityWeather> cityWeathers;

    public CountryWeather(String countryName, Set<CityWeather> cityWeathers) {
        this.countryName = countryName;
        this.cityWeathers = cityWeathers;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Set<CityWeather> getCityWeathers() {
        return cityWeathers;
    }

    public void setCityWeathers(Set<CityWeather> cityWeathers) {
        this.cityWeathers = cityWeathers;
    }
}
