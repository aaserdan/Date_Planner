package main;

import apis.*;

/** Controller used to manipulate and pass the given data to the WeatherAPI class
 *
 * Last updated February 18 2020
 * @Author Nimra
 */

public class WeatherAdapter {

    /** Method that makes a call to the weather API given zip code and country code
     *
     * @param zipCode zip code where the user is searching for food
     * @param countryCode country where user is located
     */
    public static void getWeatherInfo_ZIPCODE(int zipCode, String countryCode) {
        WeatherAPI.getWeather(zipCode, countryCode);
    }
}
