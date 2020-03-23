package apis.adapters;

/**
 * Class used to make call the Yelp API translator class
 *
 * Last updated March 19, 2020
 *
 * @Author Arturo
 */
public class YelpAPIAdapter {

    /**
     * Method to call the YelpAPI translator
     *
     * @param _term breakfast, lunch, or dinner, etc.
     * @param _city city where user is located
     * @param _limit search limit chosen by the user
     */
    public static void getRestaurant(String _term, String _city, int _limit) {
        apis.YelpAPI.findRestaurants(_term, _city, _limit);
    }
}
