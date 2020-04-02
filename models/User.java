package models;

/**
 * Model for the users
 *
 * Last updated February 19 2020
 *
 * @Author Alejandro
 */
public class User {

    private String name;
    private String city;
    private String term;
    private int zipCode;
    private String countryCode;
    private int searchLimit;

    //======================== GETTERS ========================
    /**
     * Grabs the name of the user
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Grabs the city the user gave
     *
     * @return city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Grabs the term the user gave
     *
     * @return term
     */
    public String getTerm() {
        return this.term;
    }

    /**
     * Grabs the zip code the user gave
     *
     * @return zip code
     */
    public int getZipCode() {
        return this.zipCode;
    }

    /**
     * Grabs the country code the user gave (Default set to 'US')
     *
     * @return country code
     */
    public String getCountryCode() {
        return this.countryCode;
    }

    /**
     * Grabs the yelp search limit user gave
     *
     * @return
     */
    public int getSearchLimit() {
        return this.searchLimit;
    }

    //======================== SETTERS ========================
    /**
     * Sets the name given by the user
     *
     * @param _name
     */
    public void setName(String _name) {
        this.name = _name;
    }

    /**
     * Sets the city given by the user
     *
     * @param _city
     */
    public void setCity(String _city) {
        this.city = _city;
    }

    /**
     * Sets the term given by the user
     *
     * @param _term
     */
    public void setTerm(String _term) {
        this.term = _term;
    }

    /**
     * Sets the zip code given by the user
     *
     * @param _zipCode
     */
    public void setZipCode(int _zipCode) {
        this.zipCode = _zipCode;
    }

    /**
     * Sets the country given by the user
     *
     * @param _countryCode
     */
    public void setCountryCode(String _countryCode) {
        this.countryCode = _countryCode;
    }

    /**
     * Sets the search limit for Yelp given by the user
     *
     * @param _searchLimit
     */
    public void setSearchLimit(int _searchLimit) {
        this.searchLimit = _searchLimit;
    }
}
