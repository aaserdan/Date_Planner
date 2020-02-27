package apis;

/** Class used to store the API keys used for the Date Planner application
 *
 * Last updated February 16 2020
 * @Author Alejandro, @Author Arturo
 */

public class API_keys {

    /** Method used to store the weather API key (Arturo's Key)
     *
     * @return API key for the weather API
     */
    public static String openWeatherMapAPI() {
        String api_key = "4185291754b0855664266d39e5ceee45";

        return api_key;
    }

    /** Method used to store the Yelp API key (Alejandro's Key)
     *
     * @return the API key for the Yelp API
     */
    public static String yelp() {
        String api_key = "zSd1Jyv2OvempXbBojP3cKCIY7ONgboAqkgDWCYaIvxtM7E5OT4-PcJmc9artG2HBEtubT6jPVymTtJCe_HyjjGbGYWVDIzqiZiP7BD79npE19IDsCEE20kRW3ZBXnYx";

        return api_key;
    }
}