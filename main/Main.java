package main;

/**
 * This is the main class used to run the application
 *
 * Last updated April 2 2020
 *
 * @author Nimra
 * @author Alejandro
 * @author Arturo
 */
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.*;
import views.*;
import controllers.*;

public class Main extends Application {

    /**
     * Starts application and opens to first window/stage.
     *
     * @param _primaryStage
     * @throws java.io.IOException
     */
    @Override
    public void start(Stage _primaryStage) throws IOException {

        // To load GUI from primary.xml
        Parent root = FXMLLoader.load(getClass().getResource("/views/HomeScene.fxml"));

        // To add elements to scene
        Scene _primaryScene = new Scene(root);

        // To set title
        _primaryStage.setTitle("Date Planner");

        // To set the primary scene
        _primaryStage.setScene(_primaryScene);

        // To display
        _primaryStage.show();
    }

    /** Method that runs the entire program
     *
     * @param args
     */
    public static void main(String[] args) {

        // Creating a new user from the temporary 'database'
        User userOne = userFromDatabase();
        UserView viewUserOne = new UserView();

        // Creating a controller for the user
        UserController controllerUserOne = new UserController(userOne, viewUserOne);

        // Outputting the data and results using the controller
        controllerUserOne.printResults();

        // Launching the GUI last in order to show the test results first!
        launch(args);
    }

    /**
     * Temporary 'database' for user 1 to test the application
     *
     * @return user1
     */
    private static User userFromDatabase() {
        User user1 = new User();
        user1.setName("Alex");
        user1.setCity("greensboro");
        user1.setCountryCode("us");
        user1.setTerm("pasta");
        user1.setSearchLimit(3);
        user1.setZipCode(27513);

        return user1;
    }
}
