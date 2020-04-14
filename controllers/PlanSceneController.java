package controllers;

/**
 * This class serves as the controller for the plan scene
 *
 * Last updated April 9 2020
 *
 * @author Nimra
 * @author Alejandro
 */
import apis.FoodAPIAdapter;
import apis.WeatherAPIAdapter;
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

public class PlanSceneController implements Initializable {

    // ==================================== VARIABLES ====================================

    // Variables that store the weather data to be passed to results
    String[] weatherData;
    String weatherDescription;
    String temp;

    // Arrays that store restaurant data to be passed to results
    String[] partnerOneRestaurants;
    String[] partnerTwoRestaurants;

    // Default country code used for the weather
    private final String countryCode = "us";

    //Combobox for cusine options for partner one, displays all of the options
    @FXML
    private ComboBox<String> Partner1CusinecomboBox;

    //Combobox for search limit options for partner one, displays all of the options
    @FXML
    private ComboBox<String> Partner1SearchLimitcomboBox;

    //Combobox for cusine options for partner two, displays all of the options
    @FXML
    private ComboBox<String> Partner2CusinecomboBox;

    //Combobox for search limit options for partner one, displays all of the options
    @FXML
    private ComboBox<String> Partner2SearchLimitcomboBox;

    @FXML
    private TextField partner1Name;

    @FXML
    private TextField partner2Name;

    @FXML
    private TextField city;

    @FXML
    private TextField zipCode;

    // ==================================== OBVSERVABLE LISTS ====================================

    //Combobox for cusine options for partner one, displays all of the options
    ObservableList<String> cusineOptions = FXCollections.observableArrayList("American", "Caribbean", "Chinese", "French", "Italian", "Indian", "Japanese", "Mexican", "Mediterranean", "Spanish", "Thai");

    //Combobox for search limit options for partner one, displays all of the options
    ObservableList<String> searchLimitOptions = FXCollections.observableArrayList("1", "2", "3");

    // ==================================== METHODS/ACTIONS ====================================

    /**
     * Gathers data and takes the user from plan screen to results screen
     *
     * @param _event
     * @throws java.lang.Exception
     */
    @FXML
    public void resultsButtonPressed(ActionEvent _event) throws Exception {

        // Creating models for user 1 and 2
        User partnerOne = new User();
        User partnerTwo = new User();

        // Running the methods through a try catch block to ensure inputs are valid
        try {
            // Calling methods that set/get the values for use in the program
            setPartnerOneData(partnerOne);
            setPartnerOneRestaurants(partnerOne);
            setPartnerTwoData(partnerTwo);
            setPartnerTwoRestaurants(partnerTwo);
            getWeatherData(partnerOne);
        }
        // Opens PlanSceneError scene if inputs are invalid or not all filled in
        catch (Exception ex) {
            System.out.println(ex);

            //new FXML loader and scene for new screen
            Parent root = FXMLLoader.load(getClass().getResource("/Views/PlanSceneError.fxml"));
            Scene HomeScene = new Scene(root);

            //Get information from primary stage
            Stage appStage = (Stage) ((Node) _event.getSource()).getScene().getWindow();
            appStage.setScene(HomeScene);
            appStage.show();
        }

        //new FXML loader and scene for new screen
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/ResultsScene.fxml"));
        Parent root = loader.load();
        Scene resultScene = new Scene(root);

        // Creating a controller for use throughout the class
        ResultsSceneController controller = loader.getController();

        // passing the values from the planning controller/scene to the results controller/scene
        setResultsScreenData(controller, partnerOne, partnerTwo);

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
        Partner1CusinecomboBox.setItems(cusineOptions);
        Partner2CusinecomboBox.setItems(cusineOptions);
        Partner1SearchLimitcomboBox.setItems(searchLimitOptions);
        Partner2SearchLimitcomboBox.setItems(searchLimitOptions);
    }

    /**
     * Sets the data for partner 1
     *
     * @param _partnerOne
     */
    public void setPartnerOneData(User _partnerOne) {
        _partnerOne.setName(this.partner1Name.getText());
        _partnerOne.setCity(this.city.getText().replaceAll("\\s",""));
        _partnerOne.setTerm(this.Partner1CusinecomboBox.getValue());
        _partnerOne.setSearchLimit(Integer.parseInt(this.Partner1SearchLimitcomboBox.getValue()));
        _partnerOne.setZipCode(Integer.parseInt(this.zipCode.getText()));
    }

    /**
     * Sets the restaurants array for partner 1
     *
     * @param _partnerOne
     */
    public void setPartnerOneRestaurants(User _partnerOne) {
        this.partnerOneRestaurants = FoodAPIAdapter.getRestuarants(_partnerOne.getTerm(), _partnerOne.getCity(), _partnerOne.getSearchLimit());
    }

    /**
     * Sets the data for partner 2
     *
     * @param _partnerTwo
     */
    public void setPartnerTwoData(User _partnerTwo) {
        _partnerTwo.setName(this.partner2Name.getText());
        _partnerTwo.setCity(this.city.getText().replaceAll("\\s",""));
        _partnerTwo.setTerm(this.Partner2CusinecomboBox.getValue());
        _partnerTwo.setSearchLimit(Integer.parseInt(this.Partner2SearchLimitcomboBox.getValue()));
        _partnerTwo.setZipCode(Integer.parseInt(this.zipCode.getText()));
    }

    /**
     * Sets the restaurants array for partner 2
     *
     * @param _partnerTwo
     */
    public void setPartnerTwoRestaurants(User _partnerTwo) {
        this.partnerTwoRestaurants = FoodAPIAdapter.getRestuarants(_partnerTwo.getTerm(), _partnerTwo.getCity(), _partnerTwo.getSearchLimit());
    }

    /**
     *  Grabs weather data from the API call
     *
     * @param _partnerOne
     */
    public void getWeatherData(User _partnerOne) {
        weatherData = WeatherAPIAdapter.getWeather(_partnerOne.getZipCode(), countryCode);

        // grabbing the elements from the array and putting them into their respective variables
        temp = weatherData[0];
        weatherDescription = weatherData[1];
    }

    /**
     * Method that passes the values the users inputted to the results controller
     *
     * @param _controller
     * @param _partnerOne
     * @param _partnerTwo
     */
    public void setResultsScreenData(ResultsSceneController _controller, User _partnerOne, User _partnerTwo) {
        _controller.setTemperatureLabel(temp);
        _controller.setWeatherDescription(weatherDescription);
        _controller.setPartnerOneName(_partnerOne.getName());
        _controller.setPartnerTwoName(_partnerTwo.getName());
        _controller.setPartnerOneRestaurants(partnerOneRestaurants);
        _controller.setPartnerTwoRestaurants(partnerTwoRestaurants);
    }
}
