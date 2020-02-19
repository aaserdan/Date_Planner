package main;

/** Our temporary main file for the program that is used for testing the code
 *
 * Last updated February 19 2020
 * @Author Alejandro, @Author Arturo, @Author Nimra
 */

import models.*;
import views.*;
import controllers.*;

public class Main {

    /** Main method that runs the program
     *
     */
    public static void main(String[] args) {

        User model = userFromDatabase();
        UserView view = new UserView();

        UserController controller = new UserController(model, view);

        controller.updateView();
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
