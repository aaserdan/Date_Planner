package apis;

/**
 * Class used to make call the Food API translator class
 *
 * Last updated April 1, 2020
 *
 * @Author Alejandro Penaloza
 */
public class FoodAPIAdapter implements GetRestarauntsInterface {

    /**
     * Grabs food from the Yelp API
     *
     * @param _term
     * @param _city
     * @param _limit
     */
    @Override
    public void getRestuarants(String _term, String _city, int _limit) {
        FoodAPI.findRestaurantsYelp(_term, _city, _limit);
       // throw new UnsupportedOperationException("Not supported yet.");
    }
}
