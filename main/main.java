package main;

/**
 *
 * @Authors Alejandro, Nimra, Arturo
 */
public class main {
    public static void main(String[] args) {
        
        String city = "greensboro";
        String term = "dinner";
        String zipCode = "27403";
        String countryCode = "us";
        int searchLimitYelp = 3;
        
        weatherAdapter.getWeatherInfo_ZIPCODE(zipCode, countryCode);
        yelpAdapter.getYelpInfo(term, city, searchLimitYelp);
    }
}
