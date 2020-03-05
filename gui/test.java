package gui;

/**
 * Class to display GUI to the user
 *
 *
 * Last updated March 2 2020
 *
 * @author Nimra
 */
import javafx.scene.Scene;
import controllers.UserController;
import javafx.stage.Stage;

public class test {

    // Giving access to models so they could display the information.
    private final UserController usercontroler = new UserController();
    private final Stage stage;

    /**
     *
     * @param primaryStage - Stage passed in from BeginController class.
     */
    public test(Stage primaryStage) {
        this.stage = primaryStage;

    }

    /**
     * Loads home screen screen.
     */
    public void homeScreen() {
        Scene scene = this.buildHomeScreen();
        this.stage.setTitle("Home");
        this.stage.setScene(scene);
        this.stage.show();
    }

    /**
     * Loads about us screen.
     */
    public void aboustUsScreen() {
        Scene scene = this.buildaboustUsScreen();
        this.stage.setTitle("About Us");
        this.stage.setScene(scene);
        this.stage.show();
    }

    /**
     * Loads services screen
     */
    public void servicesScreen() {
        Scene scene = this.buildservicesScreen();
        this.stage.setTitle("Services");
        this.stage.setScene(scene);
        this.stage.show();
    }

    /**
     * Loads support screen
     */
    public void supportScreen() {
        Scene scene = this.buildsupportScreen();
        this.stage.setTitle("Support");
        this.stage.setScene(scene);
        this.stage.show();
    }

    /**
     * Loads contact us screen
     */
    public void contactUsScreen() {
        Scene scene = this.buildcontactUsScreen();
        this.stage.setTitle("Contact Us");
        this.stage.setScene(scene);
        this.stage.show();
    }

    /**
     * Constructs the scene for the home screen. Model for home Screen.
     *
     * @return - Returns newly created scene object to homeScreen().
     */
    private Scene buildHomeScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Scene buildaboustUsScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Scene buildservicesScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Scene buildsupportScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Scene buildcontactUsScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

