package main;

/*
 * Our controller for the application, job of this class is to load screens and
 * send user to certain screens depending on GUI commands.
 *
 * @author nimrasami
 */
import gui.Test;
import javafx.stage.Stage;

class MainController {

    //Lets the controller know of the test file, so that different screens could could be accessed based on selections.
    protected Test gui;

    /**
     * Constructor to create the BeginController
     *
     * @param primaryStage - Will be used in AppGui class to help build the GUI
     * for the user.
     */
    MainController(Stage _primaryStage) {
        // Creates stage for the AppGui to show.
        this.gui = new Test(_primaryStage);
    }

    /**
     * This method is a controller for home screen.
     */
    private void homeScreen() {
        this.gui.homeScreen();
    }

    /**
     * This method is a controller for about us screen.
     */
    private void aboustUsScreen() {
        this.gui.aboustUsScreen();
    }

    /**
     * I might delete the services screen
     * This method is a controller for services screen.
     
    private void servicesScreen() {
        this.gui.servicesScreen();
    }
    */

    /**
     * This method is a controller for support screen.
     */
    private void supportScreen() {
        this.gui.supportScreen();
    }

    /**
     * This method is a controller for contact us screen.
     */
    private void contactUsScreen() {
        this.gui.contactUsScreen();
    }

}
