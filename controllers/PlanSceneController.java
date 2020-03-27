package controllers;
/**
 * This class serves as the controller for the plan scene
 *
 * Last updated March 20 2020
 *
 * @author Nimra
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class PlanSceneController implements Initializable {

    //Buttons to go from plan scene to result scene
    @FXML
    private Button resultsButton;

    //Combobox for setting options for partner one, displays all of the options
    @FXML
    private ComboBox<String> Partner1SettingcomboBox;

    ObservableList<String> partner1Settingoptions = FXCollections.observableArrayList("Dine In", "Take Out", "Fast Food");
    
    //Combobox for setting options for partner two, displays all of the options
    @FXML
    private ComboBox<String> Partner2SettingcomboBox;

    ObservableList<String> partner2Settingoptions = FXCollections.observableArrayList("Dine In", "Take Out", "Fast Food");

    //Combobox for cusine options for partner one, displays all of the options
    @FXML
    private ComboBox<String> Partner1CuinecomboBox;

    ObservableList<String> partner1Cusineoptions = FXCollections.observableArrayList("American","Caribbean", "Chinese", "French", "Italian", "Indian", "Japanese", "Mexican", "Mediterranean", "Spanish", "Sea Food", "Thai");
    
    //Combobox for cusine options for partner two, displays all of the options
    @FXML
    private ComboBox<String> Partner2CuinecomboBox;

    ObservableList<String> partner2Cusineoptions = FXCollections.observableArrayList("American","Caribbean", "Chinese", "French", "Italian", "Indian", "Japanese", "Mexican", "Mediterranean", "Spanish", "Sea Food", "Thai");
    
    //Combobox for distance options for partner one, displays all of the options
    @FXML
    private ComboBox<String> Partner1DistancecomboBox;

    ObservableList<String> partner1Distanceoptions = FXCollections.observableArrayList("Within 5 miles", "Within 10 miles", "Within 15 miles", "Within 20 miles", "Within 50 miles", "Within 100 miles");
    
    //Combobox for distance options for partner two, displays all of the options
    @FXML
    private ComboBox<String> Partner2DistancecomboBox;

    ObservableList<String> partner2Distanceoptions = FXCollections.observableArrayList("Within 5 miles", "Within 10 miles", "Within 15 miles", "Within 20 miles", "Within 50 miles", "Within 100 miles");
    
    //Combobox for search limit options for partner one, displays all of the options
    @FXML
    private ComboBox<String> Partner1SearchLimitcomboBox;

    ObservableList<String> partner1SearchLimitoptions = FXCollections.observableArrayList("1", "2", "3", "5", "7");
    
    //Combobox for search limit options for partner one, displays all of the options
    @FXML
    private ComboBox<String> Partner2SearchLimitcomboBox;

    ObservableList<String> partner2SearchLimitoptions = FXCollections.observableArrayList("1", "2", "3", "5", "7");
    /**
     * Takes the user from plan screen to results screen
     *
     * @param _event
     * @throws java.lang.Exception
     */
    @FXML
    public void changeToResultsScreen(ActionEvent _event) throws Exception {

        //new FXML loader and scene for new screen
        Parent root = FXMLLoader.load(getClass().getResource("/views/ResultsScene.fxml"));
        Scene resultScene = new Scene(root);

        //Get information from primary stage
        Stage rStage = (Stage) ((Node) _event.getSource()).getScene().getWindow();
        rStage.setScene(resultScene);
        rStage.show();
    }

    /**
     * This initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Partner1SettingcomboBox.setItems(partner1Settingoptions);
        Partner2SettingcomboBox.setItems(partner2Settingoptions);
        Partner1CuinecomboBox.setItems(partner1Cusineoptions);
        Partner2CuinecomboBox.setItems(partner2Cusineoptions);
        Partner1DistancecomboBox.setItems(partner1Distanceoptions);
        Partner2DistancecomboBox.setItems(partner2Distanceoptions);
        Partner1SearchLimitcomboBox.setItems(partner1SearchLimitoptions);
        Partner2SearchLimitcomboBox.setItems(partner2SearchLimitoptions);
    }

}
