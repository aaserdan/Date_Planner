package controllers;

/**
 * This class serves as the controller for all of the screens
 *
 * Last updated March 20 2020
 *
 * @author Nimra
 */
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 *
 */
public class GuiController implements Initializable {

    //FXML loader
    //Image for background
    @FXML
    private ImageView background;

    //Buttons to gor from one scene to another
    @FXML
    private Button dateButton;

    @FXML
    private Button resultsButton;

    //Combobox for setting of partner one
    @FXML
    protected ComboBox<String> settingP1ComboBox;

    //Combobox for setting of partner two
    @FXML
    protected ComboBox<String> settingP2ComboBox;

    /**
     * Changes from home screen to plan screen
     *
     * @param _event
     * @throws java.lang.Exception
     */
    public void changeToPlanScreen(ActionEvent _event) throws Exception {

        //new FXML loader and scene for new screen
        Parent root = FXMLLoader.load(getClass().getResource("/Views/PlanScene.fxml"));
        Scene HomeScene = new Scene(root);

        //Get information from primary stage
        Stage appStage = (Stage) ((Node) _event.getSource()).getScene().getWindow();
        appStage.setScene(HomeScene);
        appStage.show();
    }

    /**
     * Changes from plan screen to results screen
     *
     * @param _event
     * @throws java.lang.Exception
     */
    public void changeToResultsScreen(ActionEvent _event) throws Exception {

        //new FXML loader and scene for new screen
        Parent root = FXMLLoader.load(getClass().getResource("/Views/ResultsScene.fxml"));
        Scene resultScene = new Scene(root);

        //Get information from primary stage
        Stage rStage = (Stage) ((Node) _event.getSource()).getScene().getWindow();
        rStage.setScene(resultScene);
        rStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
