package main;
/** Our temporary main file for the program that is used for testing the code
 *
 * Last updated February 18 2020
 * @Author Alejandro, @Author Arturo, @Author Nimra
 */

public class Main {
    public static void main(String[] args) {

        String city = "greensboro";
        String term = "dinner";
        String zipCode = "27403";
        String countryCode = "us";
        int searchLimitYelp = 3;

        WeatherAdapter.getWeatherInfo_ZIPCODE(zipCode, countryCode);
        YelpAdapter.getYelpInfo(term, city, searchLimitYelp);
    }
}
