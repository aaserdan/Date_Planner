package main;


/**
 * This class is the main class it is used to start the application
 *
 * Last updated March 10 2020
 *
 * @author Nimra, ALejandro, Arturo
 */
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.*;
import views.*;
import controllers.*;


public class Main extends Application {

    /**
     * Starts application and takes it to first page.
     */
    @Override
    public void start(Stage _primaryStage) throws IOException {

        //This is to load the GUI from primary.xml
        Parent root = FXMLLoader.load(getClass().getResource("/views/gui.fxml"));

        //This is to add elements to the scene
        Scene primaryScene = new Scene(root);

        //This will set the title
        _primaryStage.setTitle("Date Planner");

        //This is to set the primary scene
        _primaryStage.setScene(primaryScene);

        //This is to display the window
        _primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

        // Creating a new user from the 'database'
        User model1 = userFromDatabase();
        UserView view1 = new UserView();

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
