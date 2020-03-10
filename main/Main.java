package main;

/** Our temporary main file for the program that is used for testing the code
 *
 * Last updated March 9 2020
 * @Author Alejandro, @Author Arturo, @Author Nimra
 */

import models.*;
import views.*;
import controllers.*;

public class Main {

    /** Main method that runs the program
     *
     * @param args
     */
    public static void main(String[] args) {

        // Creating a new user from the 'database'
        User model1 = userFromDatabase();
        UserViewTEST view1 = new UserViewTEST();

        // Creating a controller for the user
        UserController controller1 = new UserController(model1, view1);

        // Outputting the data and results using the controller
        controller1.updateView();
    }

    /** Temporary 'database' for user 1 to test the application
     *
     * @return user1
     */
    private static User userFromDatabase() {
        User user1 = new User();
        user1.setName("Alex");
        user1.setCity("greensboro");
        user1.setCountryCode("us");
        user1.setTerm("pasta");
        user1.setSearchLimitYelp(3);
        user1.setZipCode(27513);

        return user1;
    }
}
