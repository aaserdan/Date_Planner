package apis;

/**
 * Weather API class Class used to make calls to the WeatherAPI given data from
 * the WeatherAdapter
 *
 * Last updated February 24 2020
 *
 * @Author Arturo
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;

public class WeatherAPI {

    /**
     * Method used to grab data from the weather API
     *
     * @param _zipCode zip code where the user is located
     * @param _country country where the user is located
     */
    public static void getWeatherOpenWeatherMap(int _zipCode, String _country) {

        // Create a HTTP Connection.
        String baseURL = "http://api.openweathermap.org";
        String callAction = "/data/2.5/weather?q=";

        // Build the URL
        String urlString = baseURL + callAction + _zipCode + "," + _country + "&appid=" + API_keys.openWeatherMapAPI();
        URL url;

        try {

            // Creating the URL and connection
            url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Prints the respone code (USED FOR DEBUGGING)
            int status = connection.getResponseCode();

            //Response code used for debugging
            System.out.println("Weather API Response Code: " + status + " ---> SHOWN DURING DEBUG");

            /* Grabs the response from the API and appends it to the content variable
               until it's empty                                                    */
            StringBuilder content;
            try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                content = new StringBuilder();

                //Appends all of the data to the input line until there is no more data
                while ((inputLine = inputStream.readLine()) != null) {
                    content.append(inputLine);
                }
            }
            // Closing the connection after the response has been saved
            connection.disconnect();

            // Saving the data into an object
            JSONObject obj = new JSONObject(content.toString());

            // Calls to helper method to print out the weather information from JSONObjer obj
            printWeatherInf(obj);

        } catch (IOException | JSONException ex) {
            Logger.getLogger(WeatherAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method used to convert Kelvin to Celsius
     *
     * @param _temp temperature
     * @return tempCelsius contains new temperature in Celsius
     */
    public static int toCelsius(int _temp) {
        int tempCelsius = (int) (Math.ceil((_temp - 273.15)));
        return tempCelsius;
    }

    /**
     * Method used to convert Kelvin to Fahrenheit
     *
     * @param _temp temperature
     * @return tempFahrenheit contains new temperature in Fahrenheit
     */
    public static int toFahrenheit(int _temp) {
        int tempFahrenheit = (int) (((_temp - 273.15) * 1.8) + 32);
        return tempFahrenheit;
    }

    /**
     * Method to extract components for the weather from the JSON Object
     *
     * @param _obj contains information from API to be extracted
     */
    public static void printWeatherInf(JSONObject _obj) {
        try {
            // Extracting the main object from the response for the temperature
            JSONObject mainObj = _obj.getJSONObject("main");
            int currentTemp = mainObj.getInt("temp");

            // Calls to convert temperature into Celcius and Fahrenheit & prints out
            System.out.println("Current Temperature: " + toFahrenheit(currentTemp) + " F");
            System.out.println("Current Tempemrature: " + toCelsius(currentTemp) + " C");
            //Extracting the weather array for the weather description
            JSONArray jsonArray = _obj.getJSONArray("weather");
            JSONObject weatherDescription = jsonArray.getJSONObject(0);
            String weatherDesc = weatherDescription.getString("description");
            System.out.println("Weather Description: " + weatherDesc + "\n");

        } catch (JSONException ex) {
            Logger.getLogger(WeatherAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
