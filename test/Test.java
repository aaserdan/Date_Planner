package test;

/**
 * This class serves as a main class for the test class
 *
 * Last updated April 30 2020
 *
 * @author Nimra
 * @author Arturo
 */

public class Test {
    
    public static void main(String[] args) {
        
        //Strings used to test the Food API 
        String [] cuisine = {"American", "Chinese", "Italian", "Japanese", "Mexican"};
        String [] city = {"Asheboro", "Trinity", "Greensboro", "HighPoint"};
        int [] searchLimit = {1, 2, 3};
        
        //Strings used to test the weather API 
        int [] zipCode = {27203, 27360, 27407, 27235};
        String [] countryCode = {"US", "Us", "us", "UnitedStates"};
        
        //Test cases for the food/resturant API
        TestApi.testGetRestarurants(cuisine[0], city[3], searchLimit[0]);
        TestApi.testGetRestarurants(cuisine[2], city[2], searchLimit[1]);
        TestApi.testGetRestarurants(cuisine[1], city[0], searchLimit[0]);
        TestApi.testGetRestarurants(cuisine[3], city[1], searchLimit[2]);
        
        //Test cases for the weather API
        TestApi.testGetWeather(zipCode[1], countryCode[0]);
        TestApi.testGetWeather(zipCode[0], countryCode[2]);
        TestApi.testGetWeather(zipCode[3], countryCode[1]);
        TestApi.testGetWeather(zipCode[2], countryCode[1]);
    }
    
}
