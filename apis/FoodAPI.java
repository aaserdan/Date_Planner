package apis;

/**
 * Class used to make calls to the Yelp API given data from the YelpAdapter
 *
 * Last updated April 2 2020
 *
 * @Author Alejandro
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;

public class FoodAPI {
    private static final String baseUrlYelp = "https://api.yelp.com";
    private static final String callActionYelp = "/v3/businesses/search?";
    private static final int numberOfValuesForEachRestaurant = 5;

    /**
     * Method that makes a API call to the Yelp API for a list of restaurants in
     * the location given by the user
     *
     * @param _term breakfast, lunch, or dinner, etc.
     * @param _city city where user is located
     * @param _limit search limit chosen by the user
     * @return array values
     */
    public static String[] findRestaurantsYelp(String _term, String _city, int _limit) {
        int arraySpaceNeeded = _limit * numberOfValuesForEachRestaurant;
        int counterForEachRestaurant = 0;
        String[] restaurantsData = new String[arraySpaceNeeded];

        //Build the url
        String urlString = baseUrlYelp + callActionYelp + "term=" + _term + "&location=" + _city + "&limit=" + _limit;
        URL url;

        try {

            //Creating the URL and connection
            url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            //Set the request header for authorization to use the Yelp API
            connection.setRequestProperty("Authorization", "Bearer " + API_keys.yelp());

            //Prints out the response code
            int status = connection.getResponseCode();

            //Response code used for debugging
            System.out.println("Yelp API Response Code: " + status + " ---> SHOWN FOR DEBUG PURPOSES");

            /* Grabs the response from the API and appends it to the content variable
               until it's empty                                                    */
            StringBuilder content;
            try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                content = new StringBuilder();

                //Appends all of the data to the inputLine until there is no more data
                while ((inputLine = inputStream.readLine()) != null) {
                    content.append(inputLine);
                }
            }
            // Closing the connection after the response has been saved
            connection.disconnect();

            // Saves API response into an object
            JSONObject obj = new JSONObject(content.toString());
            JSONArray jsonArray = obj.getJSONArray("businesses");

            // Looping through every restaurant and adding it to the array
            for (int i = 0; i < _limit; i++) {
                JSONObject businessIndex = jsonArray.getJSONObject(i);
                JSONObject businessLocation = businessIndex.getJSONObject("location");

                restaurantsData[counterForEachRestaurant] = "Restaurant Name: " + businessIndex.getString("name");
                restaurantsData[counterForEachRestaurant += 1] = "Address: " + businessLocation.getString("address1");
                restaurantsData[counterForEachRestaurant += 1] = "Rating: " + businessIndex.getString("rating");
                restaurantsData[counterForEachRestaurant += 1] = "Price: " + businessIndex.getString("price");
                restaurantsData[counterForEachRestaurant += 1] = "Phone Number: " + businessIndex.getString("display_phone");
                counterForEachRestaurant += 1;
            }
        } catch (IOException | JSONException ex) {
            Logger.getLogger(FoodAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return restaurantsData;
    }
}
