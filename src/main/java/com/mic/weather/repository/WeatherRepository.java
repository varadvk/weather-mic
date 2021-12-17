package com.mic.weather.repository;

import com.mic.weather.exception.NotFoundException;
import com.mic.weather.model.CityWeather;
import com.mic.weather.model.CountryWeather;
import com.mic.weather.model.Weather;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class WeatherRepository {

    Set<CountryWeather> countryWeathers = new LinkedHashSet<>();

    // Indian cities
    private static final String INDIA = "India";
    private static final String INDIA_MUMBAI = "Mumbai";
    private static final String INDIA_PUNE = "Pune";
    private static final String INDIA_KOLHAPUR = "Kolhapur";
    private static final String INDIA_NASHIK = "Nashik";
    private static final String INDIA_NAGPUR = "Nagpur";

    // UK cities
    private static final String UK = "United Kingdom";
    private static final String UK_LONDON = "London";
    private static final String UK_EDINBURGH = "Edinburgh";
    private static final String UK_MANCHESTER = "Manchester";
    private static final String UK_BIRMINGHAM = "Birmingham";
    private static final String UK_GLASGOW = "Glasgow";

    // USA Cities
    private static final String USA = "United States of America";
    private static final String USA_NEW_YORK = "New York";
    private static final String USA_CHICAGO = "Chicago";
    private static final String USA_LAS_VEGAS = "Las Vegas";
    private static final String USA_SEATTLE = "Seattle";
    private static final String USA_SAN_FRANCISCO = "San Francisco";

    {
        CountryWeather indiaWeather = generateCountryData(INDIA, new String[]{INDIA_MUMBAI, INDIA_PUNE, INDIA_KOLHAPUR, INDIA_NAGPUR, INDIA_NASHIK});
        CountryWeather ukWeather = generateCountryData(UK, new String[]{UK_LONDON, UK_EDINBURGH, UK_MANCHESTER, UK_BIRMINGHAM, UK_GLASGOW});
        CountryWeather usaWeather = generateCountryData(USA, new String[]{USA_NEW_YORK, USA_CHICAGO, USA_LAS_VEGAS, USA_SEATTLE, USA_SAN_FRANCISCO});

        countryWeathers.add(indiaWeather);
        countryWeathers.add(ukWeather);
        countryWeathers.add(usaWeather);
    }

    public Set<CountryWeather> getWeather() {
        return countryWeathers;
    }

    public CountryWeather getWeatherByCountry(String countryName) {
        return countryWeathers
                .stream()
                .filter(countryWeather -> countryWeather.getCountryName().equalsIgnoreCase(countryName))
                .findFirst()
                .orElseThrow(() -> {
                    throw new NotFoundException("Country with name " + countryName + " not found");
                });
    }

    public Set<CityWeather> getTodayWeatherByCountry(String countryName) {

        return getWeatherByCountry(countryName).getCityWeathers()
                .stream()
                .map(x -> {
                            Set<Weather> a = x.getCityWeather()
                                    .stream()
                                    .filter(y -> y.getWeatherDate().equals(LocalDate.now()))
                                    .collect(Collectors.toSet());

                            return new CityWeather(x.getCityName(), a);
                        }
                ).collect(Collectors.toSet());
    }

    public CityWeather getWeatherByCity(String cityName) {
        return countryWeathers
                .stream()
                .map(x -> {
                    return x.getCityWeathers()
                            .stream()
                            .filter(y -> y.getCityName().equalsIgnoreCase(cityName))
                            .findFirst()
                            .orElseThrow(() -> {
                                throw new NotFoundException("City with name " + cityName + " not found");
                            });
                }).findFirst().get();
    }

    public Weather getTodayWeatherByCity(String cityName) {
        return getWeatherByCity(cityName).getCityWeather()
                .stream()
                .filter(x -> x.getWeatherDate().equals(LocalDate.now()))
                .findFirst()
                .get();
    }

    private CountryWeather generateCountryData(String country, String[] cities) {
        Set<CityWeather> cityWeathers = new LinkedHashSet<>();

        for (String cityName : cities) {
            CityWeather cityWeather = new CityWeather(cityName, generateWeatherReport(country));
            cityWeathers.add(cityWeather);
        }

        return new CountryWeather(country, cityWeathers);
    }

    private Set<Weather> generateWeatherReport(String country) {
        Set<Weather> weathers = new LinkedHashSet<>();

        int minimumTemperature = 0;
        int maximumTemperature = 0;

        if (country.equals(INDIA)) {
            minimumTemperature = 10;
            maximumTemperature = 30;
        } else {
            minimumTemperature = -10;
            maximumTemperature = 20;
        }

        for (int i = 0; i <= 2; i++) {
            LocalDate date = LocalDate.now().plusDays(i);
            int celsius = new Random().ints(minimumTemperature, maximumTemperature).findAny().getAsInt();
            int fahrenheit = celsiusToFahrenheit(celsius);

            String summary = null;

            if (celsius < 0) {
                summary = "Snow";
            } else if (celsius < 10) {
                summary = "Cold";
            } else if (celsius < 20) {
                summary = "Cloudy";
            } else {
                summary = "Hot";
            }

            Weather weather = new Weather(date, celsius, fahrenheit, summary);
            weathers.add(weather);
        }

        return weathers;
    }

    private int celsiusToFahrenheit(int celsius) {
        return ((celsius * 9) / 5) + 32;
    }

}
