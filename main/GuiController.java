/**
 * FXML Controller class
 *
 * Last updated March 10 2020
 *
 * @author nimrasami
 */
package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class GuiController extends Application {

    @FXML
    private ImageView background;

    @Override
    public void start(Stage _primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/views/gui.fxml"));

        Scene scene = new Scene(root);

        _primaryStage.setScene(scene);
        
        //This is to display the window
        _primaryStage.show();

    }

}
