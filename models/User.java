package models;

/**
 * Model for the users
 *
 * Last updated February 18 2020
 *
 * @Author Alejandro
 */
public class User {

    private String name;
    private String city;
    private String term;
    private int zipCode;
    private String countryCode;
    private int searchLimitYelp;

    //======================== GETTERS ========================

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    public String getTerm() {
        return this.term;
    }

    public int getZipCode() {
        return this.zipCode;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public int getSearchLimitYelp() {
        return this.searchLimitYelp;
    }

    //======================== SETTERS ========================

    public void setName(String _name) {
        this.name = _name;
    }

    public void setCity(String _city) {
        this.city = _city;
    }

    public void setTerm(String _term) {
        this.term = _term;
    }

    public void setZipCode(int _zipCode) {
        this.zipCode = _zipCode;
    }

    public void setCountryCode(String _countryCode) {
        this.countryCode = _countryCode;
    }

    public void setSearchLimitYelp(int _searchLimitYelp) {
        this.searchLimitYelp = _searchLimitYelp;
    }
}