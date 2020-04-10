package controllers;

/**
 * Controller used to manipulate the users data and make calls to the
 * appropriate models and views
 *
 * Last updated April 9 2020
 *
 * @Author Alejandro
 * @Author Nimra
 * @Author Arturo
 */

import models.User;

public class UserController {

    private final User model;

    /**
     * Creates the controller for the model & view
     *
     * @param _model
     */
    public UserController(User _model) {
        this.model = _model;
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
     * Sets the Yelp search limit for the model
     *
     * @param _searchLimit
     */
    public void setSearchLimit(int _searchLimit) {
        model.setSearchLimit(_searchLimit);
    }

    //======================== GETTERS ========================
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
     * Grabs the Yelp search limit given to the model
     *
     * @return searchLmit
     */
    public int getSearchLimit() {
        return model.getSearchLimit();
    }
}
