package dynamic;

import java.util.ArrayList;

/*class defines all cities for a journey*/
public class TourManager {
    /* create a list to hold cities */
    private static ArrayList<City> journeyCities = new ArrayList<City>();

    /* method to add a city to list */
    public static void addCity(City city) {
        journeyCities.add(city);
    }

    /* get city in list with it's index */
    public static City getCity(int index) {
        return (City) journeyCities.get(index);
    }

    /* get nummber of cities in journey */
    public static int numberOfCities() {
        return journeyCities.size();
    }
}