package main;

/** Our temporary main file for the program that is used for testing the code
 *
 * Last updated February 18 2020
 * @Author Alejandro, @Author Arturo, @Author Nimra
 */

import models.*;
import views.*;
import controllers.*;

public class Main {
    public static void main(String[] args) {

        User model = userFromDatabase();
        UserView view = new UserView();

        UserController controller = new UserController(model, view);

        controller.updateView();

        /** LINES 26-33 ARE STRICTLY FOR TESTING THE API. DO NOT DELETE.
         *
         */
        String city = "greensboro";
        String term = "dinner";
        int zipCode = 27403;
        String countryCode = "us";
        int searchLimitYelp = 3;

        WeatherAdapter.getWeatherInfo_ZIPCODE(zipCode, countryCode);
        YelpAdapter.getYelpInfo(term, city, searchLimitYelp);
    }

    /** Temporary 'database' to test the application
     *
     * @return user
     */
    private static User userFromDatabase() {
        User user = new User();
        user.setName("Alex");
        user.setCity("greensboro");
        user.setCountryCode("us");
        user.setTerm("dinner");
        user.setSearchLimitYelp(3);
        user.setZipCode(27403);

        return user;
    }
}
