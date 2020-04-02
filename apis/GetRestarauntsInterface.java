package apis;

/**
 * Interface used for API food calls
 *
 * @author Alex
 *
 * Last updated 4/1/2020 (No April Fools)
 */
public interface GetRestarauntsInterface {

    /**
     * Grabs food from the Yelp API
     *
     * @param _term The term used to look for a certain type of food
     * @param _city The city given by the user
     * @param _limit The
     */
    void getRestuarants(String _term, String _city, int _limit);
}
