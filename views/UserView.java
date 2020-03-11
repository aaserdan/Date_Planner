package views;

/** View for the user information and requested data
 *
 * Last updated February 19 2020
 *
 * @Author Alejandro
 */

public class UserView {

    /** Method that outputs the results to the user. Use this to modify the
     * output to the console.
     *
     * @param _name name of the user
     * @param _city city given by user
     * @param _term term given by user ('pasta', 'seafood', etc.)
     * @param _zipCode zip code given by user
     * @param _countryCode country code given by user (ex. 'us')
     * @param _searchLimitYelp search limit given by user
     */
    public void printResults(String _name, String _city, String _term, int _zipCode, String _countryCode, int _searchLimitYelp) {
        System.out.println("Data given: ");

        System.out.println("User: " + _name);
        System.out.println("City: " + _city);
        System.out.println("Term Used: " + _term);
        System.out.println("Zip Code: " + _zipCode);
        System.out.println("Country Code: " + _countryCode);
        System.out.println("Search Limit: " + _searchLimitYelp);

        // Here to seperate the data given and the results of the program
        System.out.println("================================================");
    }
}