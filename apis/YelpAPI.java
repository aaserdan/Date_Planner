package apis;

/** Class used to make calls to the Yelp API given data from the YelpAdapter
 *
 * Last updated February 26 2020
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

public class YelpAPI {

    /** Method that makes a API call to the Yelp API for a list of restaurants
     * in the location given by the user
     *
     * @param _term breakfast, lunch, or dinner, etc.
     * @param _city city where user is located
     * @param _limit search limit chosen by the user
     */
    public static void findRestaurants(String _term, String _city, int _limit) {

        // Create a HTTP Connection.
        String baseUrl = "https://api.yelp.com";
        String callAction = "/v3/businesses/search?";

        //Build the url
        String urlString = baseUrl + callAction + "term=" + _term + "&location=" + _city + "&limit=" + _limit;
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
            System.out.println("Yelp API Response Code: " + status + " ---> SHOWN DURING DEBUG");

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

            // Outputting the restaurants and their respective ratings
            for (int i = 0; i < _limit; i++) {
                JSONObject businessIndex = jsonArray.getJSONObject(i);
                JSONObject businessLocation = businessIndex.getJSONObject("location");

                // Grabbing all restaurant data and placing them in their respective variables
                String restaurantAddress = businessLocation.getString("address1");
                String restaurantName = businessIndex.getString("name");
                String restaurantRating = businessIndex.getString("rating");
                String priceRange = businessIndex.getString("price");
                String phoneNum = businessIndex.getString("display_phone");

                // Displaying all of the restaurant data
                System.out.println("Restaurant " + (i + 1) + ":");
                System.out.println("-------- * --------");
                System.out.println("Restaurant Name: " + restaurantName + "");
                System.out.println("Address: " + restaurantAddress);
                System.out.println("Phone Number: " + phoneNum);
                System.out.println("Rating: " + restaurantRating);
                System.out.println("Price: " + priceRange + "\n");
            }
        } catch (IOException | JSONException ex) {
            Logger.getLogger(YelpAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}