package apis;

/**
 * Grabs weather from the weather API
 *
 * @author Arturo
 * Last updated 4/1/2020
 */
public interface WeatherAPIInterface {

    /**
     * Grabs the weather from the weather API
     *
     * @param _zipCode
     * @param _countryCode
     * @return an Array String with the weather information from the API
     */
    String [] getWeather(int _zipCode, String _countryCode);
}
