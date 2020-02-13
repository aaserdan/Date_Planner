package main;

public class weatherAdapter {
    
    public static void getWeatherInfo_ZIPCODE(String zipCode, String countryCode) {
        weatherAPI.getWeather(zipCode, countryCode);
    }
    
}
