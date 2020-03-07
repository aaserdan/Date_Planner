package main;

/**
 * Main class for GUI
 *
 *
 * Last updated March 4 2020
 *
 * @author Nimra
 */

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 *Class where the application starts.
 */
public class GUIMain extends Application {

    @Override
    public void start(Stage _primaryStage) {
        //New object is created and passing it the stage to begin the program
        MainController mainControl = new MainController(_primaryStage);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
