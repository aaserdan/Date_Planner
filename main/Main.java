package main;

/** Our temporary main file for the program that is used for testing the code
 *
 * Last updated February 24 2020
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
        User model1 = userFromDatabase();
        UserView view1 = new UserView();

    //  User model2 = user2FromDatabase();
    //  UserView view2 = new UserView();

        UserController controller1 = new UserController(model1, view1);
    //  UserController controller2 = new UserController(model2, view2);

        controller1.updateView();
    //  controller2.updateView();
    }

    /** Temporary 'database' for user 1 to test the application
     *
     * @return user1 data
     */
    private static User userFromDatabase() {
        User user1 = new User();
        user1.setName("Brandon");
        user1.setCity("raleigh");
        user1.setCountryCode("us");
        user1.setTerm("pasta");
        user1.setSearchLimitYelp(7);
        user1.setZipCode(27513);

        return user1;
    }

    /** Temporary 'database' for user 2 to test the application
     *
     * @return user2 data
     */
    private static User user2FromDatabase() {
        User user2 = new User();
        user2.setName("Myra");
        user2.setCity("raleigh");
        user2.setCountryCode("us");
        user2.setTerm("dinner");
        user2.setSearchLimitYelp(5);
        user2.setZipCode(27513);

        return user2;
    }
}
