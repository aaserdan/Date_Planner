package apis;

/**
 * Class used to make calls the Food API translator class
 *
 * Last updated April 1, 2020
 *
 * @Author Alejandro Penaloza
 */
public class FoodAPIAdapter {

    /**
     * Grabs food from the Yelp API
     *
     * @param _term
     * @param _city
     * @param _limit
     * @return restaurant data
     */
    public static String[] getRestuarants(String _term, String _city, int _limit) {
        String[] restaurantsData;

        // Creates a new instance for the API request
        FoodAPI getFood = new FoodAPI();

        // Grabs restaraunts from the API (USES TERM, CITY, SEARCHLIMIT IN THAT ORDER)
        restaurantsData = getFood.getRestuarants(_term, _city, _limit);
        return restaurantsData;
    }
}
