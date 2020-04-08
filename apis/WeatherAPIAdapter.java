package apis;

/**
 * Weather API Adapter class Class used to make calls to the WeatherAPI given
 * data from the WeatherAdapter
 *
 * Last updated April 7, 2020
 *
 * @Author Arturo
 */

public class WeatherAPIAdapter{

    /**
     * Grabs weather from the API
     *
     * @param _zipCode
     * @param _countryCode
     * @return weather data in a string array
     */
    public static String [] getWeather(int _zipCode, String _countryCode) {
        // String Array to be returned with the weather API's information
        String [] weatherInf;
        // Creates a new instance for the API request
        OpenWeatherMapAPI getWeatherInf = new OpenWeatherMapAPI();

        // Grabs the weather information from the API (USES ZIPCODE, COUNTRYCODE IN THAT ORDER)
        weatherInf = getWeatherInf.getWeather(_zipCode, _countryCode);
        return weatherInf;
    }
}
