package main;

/** Controller used to manipulate and pass the given data to the YelpAPI class
 *
 * Last updated February 18 2020
 * @Author Nimra
 */

public class YelpAdapter {

    /** Method used to call the Yelp API given the term, city, and search limit
     *
     * @param term breakfast, lunch, or dinner
     * @param city city the user is located in
     * @param limit search limit for the results
     */
    public static void getYelpInfo(String term, String city, int limit) {
        YelpAPI.findRestaurants(term, city, limit);
    }
}
