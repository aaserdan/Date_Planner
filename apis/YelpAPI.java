package apis;

/** Class used to make calls to the Yelp API given data from the YelpAdapter
 *
 * Last updated February 18 2020
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
            System.out.println("Response Code: " + status);

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            //Appends all of the data to the inputLine until there is no more data
            while ((inputLine = inputStream.readLine()) != null) {
                content.append(inputLine);
            }
            inputStream.close();
            connection.disconnect();

            //Outputs the content
            System.out.println("Output: " + content.toString());
            JSONObject obj = new JSONObject(content.toString());

        } catch (IOException | JSONException ex) {
            Logger.getLogger(YelpAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}