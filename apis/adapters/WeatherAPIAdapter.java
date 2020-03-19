package apis.adapters;

/**
 * Weather API Adapter class Class used to make calls to the WeatherAPI given
 * data from the WeatherAdapter
 *
 * Last updated March 19, 2020
 *
 * @Author Arturo
 */
import apis.WeatherAPI;

public class WeatherAPIAdapter {

    /**
     * Method used to call the Weather API to get the weather information
     * Calls to OpeanWeatherAPI translator
     * @param _zipCode zip code where the user is located
     * @param _countryCode country where the user is located
     */
    public static void getWeatherInfo(int _zipCode, String _countryCode) {
        WeatherAPI.getWeatherOpenWeatherMap(_zipCode, _countryCode);
    }
}
