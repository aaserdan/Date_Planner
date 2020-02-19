package controllers;

/** Controller used to manipulate the users data and make calls to the
 *  appropriate models and views
 *
 * Last updated February 19 2020
 * @Author Alejandro
 */

import models.*;
import views.*;
import apis.*;

public class UserController {
    private User model;
    private UserView view;

    public UserController(User _model, UserView _view){
        this.model = _model;
        this.view = _view;
    }

    /** Updates the view
     *
     */
    public void updateView() {
        view.printResults(model.getName(), model.getCity(), model.getTerm(), model.getZipCode(), model.getCountryCode(), model.getSearchLimitYelp());
    }

    //======================== SETTERS ========================

    public void setName(String _name) {
        model.setName(_name);
    }

    public void setCity(String _city) {
        model.setCity(_city);
    }

    public void setTerm(String _term) {
        model.setTerm(_term);
    }

    public void setZipCode(int _zipcode) {
        model.setZipCode(_zipcode);
    }

    public void setCountryCode(String _countryCode) {
        model.setCountryCode(_countryCode);
    }

    public void setYelpSearchLimit(int _searchLimit) {
        model.setSearchLimitYelp(_searchLimit);
    }

    //======================== GETTERS ========================

    public String getName() {
        return model.getName();
    }

    public String getCity() {
        return model.getCity();
    }

    public String getTerm() {
        return model.getTerm();
    }

    public int getZipCode() {
        return model.getZipCode();
    }

    public String getCountryCode() {
        return model.getCountryCode();
    }

    public int getYelpSearchLimit() {
        return model.getSearchLimitYelp();
    }
}
