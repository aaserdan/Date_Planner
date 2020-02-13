package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;

/**
 *
 *
 */
public class yelpAPI {

    public static void findRestaurants(String term, String location, int limit) {

        // Create a HTTP Connection.
        String baseUrl = "https://api.yelp.com";
        String callAction = "/v3/businesses/search?";

        //Build the url
        String urlString = baseUrl + callAction + "term=" + term + "&location=" + location + "&limit=" + limit;
        URL url;

        try {

            //Creating the URL and connection
            url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            //Set the request header for authorization to use the Yelp API
            connection.setRequestProperty("Authorization", "Bearer " + api_keys.YELP());

            //Prints out the response code
            int status = connection.getResponseCode();
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
            Logger.getLogger(yelpAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
