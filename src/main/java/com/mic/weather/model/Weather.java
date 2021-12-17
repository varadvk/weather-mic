package com.mic.weather.model;

import java.time.LocalDate;

public class Weather {

    private LocalDate weatherDate;
    private int weatherTemperatureCelsius;
    private int weatherTemperatureFahrenheit;
    private String weatherSummary;

    public Weather(LocalDate weatherDate, int weatherTemperatureCelsius, int weatherTemperatureFahrenheit, String weatherSummary) {
        this.weatherDate = weatherDate;
        this.weatherTemperatureCelsius = weatherTemperatureCelsius;
        this.weatherTemperatureFahrenheit = weatherTemperatureFahrenheit;
        this.weatherSummary = weatherSummary;
    }

    public LocalDate getWeatherDate() {
        return weatherDate;
    }

    public void setWeatherDate(LocalDate weatherDate) {
        this.weatherDate = weatherDate;
    }

    public int getWeatherTemperatureCelsius() {
        return weatherTemperatureCelsius;
    }

    public void setWeatherTemperatureCelsius(int weatherTemperatureCelsius) {
        this.weatherTemperatureCelsius = weatherTemperatureCelsius;
    }

    public int getWeatherTemperatureFahrenheit() {
        return weatherTemperatureFahrenheit;
    }

    public void setWeatherTemperatureFahrenheit(int weatherTemperatureFahrenheit) {
        this.weatherTemperatureFahrenheit = weatherTemperatureFahrenheit;
    }

    public String getWeatherSummary() {
        return weatherSummary;
    }

    public void setWeatherSummary(String weatherSummary) {
        this.weatherSummary = weatherSummary;
    }
}
