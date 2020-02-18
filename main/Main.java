package main;

/**
 *
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
