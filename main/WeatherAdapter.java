package main;

public class WeatherAdapter {

    public static void getWeatherInfo_ZIPCODE(String zipCode, String countryCode) {
        WeatherAPI.getWeather(zipCode, countryCode);
    }

}
