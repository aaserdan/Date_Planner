package adapters;

/**
 * Class used to make call the Food API translator class
 *
 * Last updated March 19, 2020
 *
 * @Author Arturo
 */
public class FoodAPIAdapter {

    /**
     * Method to call the FoodAPI translator
     *
     * @param _term breakfast, lunch, or dinner, etc.
     * @param _city city where user is located
     * @param _limit search limit chosen by the user
     */
    public static void getRestaurant(String _term, String _city, int _limit) {
        apis.FoodAPI.findRestaurantsYelp(_term, _city, _limit);
    }
}
