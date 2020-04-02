package apis;

/**
 * Weather API Adapter class Class used to make calls to the WeatherAPI given
 * data from the WeatherAdapter
 *
 * Last updated March 19, 2020
 *
 * @Author Arturo
 */

public class WeatherAPIAdapter implements WeatherAPIInterface{

    /**
     * Grabs weather from the API
     *
     * @param _zipCode
     * @param _countryCode
     */
    @Override
    public void getWeather(int _zipCode, String _countryCode) {
        WeatherAPI.getWeatherOpenWeatherMap(_zipCode, _countryCode);
    }

}
