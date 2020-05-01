package test;

/**
 * This class serves as a test class for the API calls to two different API's
 *
 * Last updated April 30 2020
 *
 * @author Nimra
 */

import apis.*;

public class TestApi {

/**
 * It is calling the FoodAPIAdapter to call the FoodAPI to get the restaurants from the Yelp API, 
 * and prints out the restaurants
 * 
 * @param _term
 * @param _city
 * @param _limit 
 */
   public static void testGetRestarurants(String _term, String _city, int _limit) {
       String [] restaurants = FoodAPIAdapter.getRestuarants(_term, _city, _limit);
       for (int i=0; i<restaurants.length; i++) {
               System.out.println(restaurants[i]);
   }
   
   }
   
 /**
 * It is calling the WeatherAPIAdapter to call the OpenWeatherMapAPI to get the weather from the OpenWeatherMap API , 
 * and prints out the weather
 * 
 * @param _zipCode
 * @param _countryCode

 */
   public static void testGetWeather (int _zipCode, String _countryCode) {
       String [] weather = WeatherAPIAdapter.getWeather(_zipCode, _countryCode) ;
       for (int i=0; i<weather.length; i++) {
               System.out.println(weather[i]);
   }
   
   }
}
