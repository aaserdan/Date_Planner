package views;

/** View for the user information and requested data
 *
 * Last updated February 18 2020
 *
 * @Author Alejandro
 */

public class UserView {
    public void printResults(String _name, String _city, String _term, int _zipCode, String _countryCode, int _searchLimitYelp) {
        System.out.println("User: " + _name);
        System.out.println("City: " + _city);
        System.out.println("Term Used: " + _term);
        System.out.println("Zip Code: " + _zipCode);
        System.out.println("Country Code: " + _countryCode);
        System.out.println("Search Limit: " + _searchLimitYelp);
    }
}