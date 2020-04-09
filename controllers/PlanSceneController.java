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
import models.*;
import views.*;

public class PlanSceneController implements Initializable {

    // ==================================== VARIABLES ====================================

    //Combobox for cusine options for partner one, displays all of the options
    @FXML
    private ComboBox<String> Partner1CuinecomboBox;

    //Combobox for search limit options for partner one, displays all of the options
    @FXML
    private ComboBox<String> Partner1SearchLimitcomboBox;

    //Combobox for cusine options for partner two, displays all of the options
    @FXML
    private ComboBox<String> Partner2CuinecomboBox;

    //Combobox for search limit options for partner one, displays all of the options
    @FXML
    private ComboBox<String> Partner2SearchLimitcomboBox;

    @FXML // fx:id = partner1Name
    private TextField partner1Name;

    @FXML // fx:id = partner2Name
    private TextField partner2Name;

    @FXML // fx:id = city
    private TextField city;

    @FXML // fx:id = zipCode
    private TextField zipCode;

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
        User partnerOne = new User();
        User partnerTwo = new User();

        partnerOne.setName(this.partner1Name.getText());
        partnerOne.setCity(this.city.getText());
        partnerOne.setTerm(this.Partner1CuinecomboBox.getValue());
        partnerOne.setSearchLimit(Integer.parseInt(this.Partner1SearchLimitcomboBox.getValue()));
        partnerOne.setZipCode(Integer.parseInt(this.zipCode.getText()));

        partnerTwo.setName(this.partner2Name.getText());
        partnerTwo.setCity(this.city.getText());
        partnerTwo.setTerm(this.Partner2CuinecomboBox.getValue());
        partnerTwo.setSearchLimit(Integer.parseInt(this.Partner2SearchLimitcomboBox.getValue()));
        partnerTwo.setZipCode(Integer.parseInt(this.zipCode.getText()));

        UserView viewPartnerOne = new UserView();
        UserView viewPartnerTwo = new UserView();

        UserController controllerPartnerOne = new UserController(partnerOne, viewPartnerOne);
        UserController controllerPartnerTwo = new UserController(partnerTwo, viewPartnerTwo);

        controllerPartnerOne.printResults();
        controllerPartnerTwo.printResults();


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
