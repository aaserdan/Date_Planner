package main;

/**
 * This is the main class used to run the application
 *
 * Last updated April 8 2020
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

public class Main extends Application {


    /** Runs the entire program
     *
     * @param args
     */
    public static void main(String[] args) {
        // Launches the GUI
        launch(args);
    }

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
}
