package main;

public class yelpAdapter {

    public static void getYelpInfo(String term, String city, int limit) {
        yelpAPI.findRestaurants(term, city, limit);
    }
}
