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
     */
    void getWeather(int _zipCode, String _countryCode);
}
