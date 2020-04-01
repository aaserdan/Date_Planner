package controllers;

/**
 * Controller used to manipulate the users data and make calls to the
 * appropriate models and views
 *
 * Last updated February 27 2020
 *
 * @Author Alejandro
 */
import models.*;
import views.*;

public class UserController {

    private final User model;
    private final UserView view;

    /**
     * Creates the controller for the model & view
     *
     * @param _model
     * @param _view
     */
    public UserController(User _model, UserView _view) {
        this.model = _model;
        this.view = _view;
    }

    /**
     * Updates the view that outputs the data
     *
     */
    public void updateView() {
        view.printResults(model.getName(), model.getCity(), model.getTerm(), model.getZipCode(), model.getCountryCode(), model.getSearchLimitYelp());
        getWeather();
        getRestaurants();
    }

    //======================== SETTERS ========================
    /**
     * Sets the name for the model
     *
     * @param _name
     */
    public void setName(String _name) {
        model.setName(_name);
    }

    /**
     * Sets the city for the model
     *
     * @param _city
     */
    public void setCity(String _city) {
        model.setCity(_city);
    }

    /**
     * Sets the term for the model
     *
     * @param _term
     */
    public void setTerm(String _term) {
        model.setTerm(_term);
    }

    /**
     * Sets the zip code for the model
     *
     * @param _zipcode
     */
    public void setZipCode(int _zipcode) {
        model.setZipCode(_zipcode);
    }

    /**
     * Sets the country code for the model
     *
     * @param _countryCode
     */
    public void setCountryCode(String _countryCode) {
        model.setCountryCode(_countryCode);
    }

    /**
     * Sets the Yelp search limit for the model
     *
     * @param _searchLimit
     */
    public void setYelpSearchLimit(int _searchLimit) {
        model.setSearchLimitYelp(_searchLimit);
    }

    //======================== GETTERS ========================
    // Grabs the restaurant data from the Yelp API
    public void getRestaurants() {
        String term = model.getTerm();
        String city = model.getCity();
        int SearchLimit = model.getSearchLimitYelp();
        adapters.FoodAPIAdapter.getRestaurant(model.getTerm(), model.getCity(), model.getSearchLimitYelp());
    }

    // Grabs the weather data from the API
    public void getWeather() {
        adapters.WeatherAPIAdapter.getWeatherInfo(model.getZipCode(), model.getCountryCode());
    }

    /**
     * Grabs the name of the user
     *
     * @return name
     */
    public String getName() {
        return model.getName();
    }

    /**
     * Grabs the city of the model
     *
     * @return city
     */
    public String getCity() {
        return model.getCity();
    }

    /**
     * Grabs the term of the model
     *
     * @return term
     */
    public String getTerm() {
        return model.getTerm();
    }

    /**
     * Grabs the zip code given to the model
     *
     * @return zipCode
     */
    public int getZipCode() {
        return model.getZipCode();
    }

    /**
     * Grabs the country code given to the model
     *
     * @return countryCode
     */
    public String getCountryCode() {
        return model.getCountryCode();
    }

    /**
     * Grabs the Yelp search limit given to the model
     *
     * @return searchLmit
     */
    public int getYelpSearchLimit() {
        return model.getSearchLimitYelp();
    }
}
