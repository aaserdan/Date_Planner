package apis;

/**
 * Class used to make call the Food API translator class
 *
 * Last updated April 1, 2020
 *
 * @Author Alejandro Penaloza
 */
public class FoodAPIAdapter implements GetRestaurantsInterface {

    /**
     * Grabs food from the Yelp API
     *
     * @param _term
     * @param _city
     * @param _limit
     */
    @Override
    public String[] getRestuarants(String _term, String _city, int _limit) {
        String[] restaurantsData;

        restaurantsData = FoodAPI.findRestaurantsYelp(_term, _city, _limit);

        return restaurantsData;
    }
}
