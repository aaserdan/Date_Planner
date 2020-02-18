package main;

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
    private String zipCode;
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

    public String getZipCode() {
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
        this.city = _term;
    }

    public void setZipCode(String _zipCode) {
        this.city = _zipCode;
    }

    public void setCountryCode(String _countryCode) {
        this.city = _countryCode;
    }

    public void setSearchLimitYelp(String _searchLimitYelp) {
        this.city = _searchLimitYelp;
    }
}