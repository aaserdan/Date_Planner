package main;

public class YelpAdapter {

    public static void getYelpInfo(String term, String city, int limit) {
        YelpAPI.findRestaurants(term, city, limit);
    }
}
