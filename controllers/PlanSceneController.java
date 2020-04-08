package controllers;

/**
 * This class serves as the controller for the plan scene
 *
 * Last updated April 8 2020
 *
 * @author Nimra
 * @author Alejandro
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlanSceneController implements Initializable {

    // ==================================== VARIABLES ====================================

    //Combobox for cusine options for partner one, displays all of the options
    @FXML private ComboBox<String> Partner1CuinecomboBox;

    //Combobox for search limit options for partner one, displays all of the options
    @FXML private ComboBox<String> Partner1SearchLimitcomboBox;

    //Combobox for cusine options for partner two, displays all of the options
    @FXML private ComboBox<String> Partner2CuinecomboBox;

    //Combobox for search limit options for partner one, displays all of the options
    @FXML private ComboBox<String> Partner2SearchLimitcomboBox;

    @FXML private TextField partner1Name;
    @FXML private TextField partner2Name;

    @FXML private TextField city;
    @FXML private TextField zipCode;

    // ==================================== OBVSERVABLE LISTS ====================================

    //Combobox for cusine options for partner one, displays all of the options
    ObservableList<String> Cusineoptions = FXCollections.observableArrayList("American","Caribbean", "Chinese", "French", "Italian", "Indian", "Japanese", "Mexican", "Mediterranean", "Spanish", "Sea Food", "Thai");

    //Combobox for search limit options for partner one, displays all of the options
    ObservableList<String> SearchLimitoptions = FXCollections.observableArrayList("1", "2", "3", "5", "7");

    // ==================================== METHODS/ACTIONS ====================================

    /**
     * Gathers data and takes the user from plan screen to results screen
     *
     * @param _event
     * @throws java.lang.Exception
     */
    @FXML
    public void resultsButtonPressed(ActionEvent _event) throws Exception {

        String partnerOneName = this.partner1Name.getText();
        String partnerTwoName = this.partner2Name.getText();
        String cityGiven = this.city.getText();
        String zipCodeGiven = this.zipCode.getText();

        System.out.println("Switching to results screen...");
        System.out.println(partnerOneName);
        System.out.println(partnerTwoName);
        System.out.println(cityGiven);
        System.out.println(zipCodeGiven);

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
        Partner1CuinecomboBox.setItems(Cusineoptions);
        Partner2CuinecomboBox.setItems(Cusineoptions);
        Partner1SearchLimitcomboBox.setItems(SearchLimitoptions);
        Partner2SearchLimitcomboBox.setItems(SearchLimitoptions);
    }

}
