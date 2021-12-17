# weather-mic

Git Link to project - https://github.com/varadvk/weather-mic

Technology stacks used.

1. Java 8
2. Spring Boot

Note:

1. Need to take care of using correct port number in URL (Default port number is 8080).
2. These end point can be tested using any api tester like postman or can be used in any browser directly.

REST end points created.

1. http://localhost:8080/weather/ :This end point will return weather information of all countries (and all cities).

2. http://localhost:8080/weather/country/{countryName}/ :This end point will return weather information (for next 3
   days) for given country (City wise).

3. http://localhost:8080/weather/country/{countryName}/today/ :This end point will return weather information (today's
   weather) for given country (City wise).

4. http://localhost:8080/weather/city/{cityName}/ :This end point will return weather information (for next 3 days) for
   given city.

5. http://localhost:8080/weather/city/{cityName}/today/ :This end point will return weather information (today's
   weather) for given city.