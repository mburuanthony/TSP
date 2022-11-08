package nondeterministic;

import java.util.ArrayList;
import java.util.Collections;

/*class defines tour in journey*/
public class Tour {
    /* create list to hold cities */
    private ArrayList<City> tour = new ArrayList<City>();
    private int distance = 0;

    /* Constructs an empty tour */
    public Tour() {
        for (int i = 0; i < RouteManager.numberOfCities(); i++) {
            tour.add(null);
        }
    }

    /* onstructs a tour from another tour */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Tour(ArrayList tour) {
        this.tour = (ArrayList<City>) tour.clone();
    }

    /* get tour information */
    @SuppressWarnings("rawtypes")
    public ArrayList getTour() {
        return tour;
    }

    /* create a random route */
    public void generateIndividual() {
        for (int cityIndex = 0; cityIndex < RouteManager.numberOfCities(); cityIndex++) {
            setCity(cityIndex, RouteManager.getCity(cityIndex));
        }

        Collections.shuffle(tour);
    }

    /* gets a city from the tour */
    public City getCity(int tourPosition) {
        return (City) tour.get(tourPosition);
    }

    /* set a city in a certain position within th tour */
    public void setCity(int tourPosition, City city) {
        tour.set(tourPosition, city);

        distance = 0;
    }

    /* gets the total distance of the tour */
    public int getDistance() {
        if (distance == 0) {
            int tourDistance = 0;

            for (int cityIndex = 0; cityIndex < tourSize(); cityIndex++) {
                /* get previous city */
                City fromCity = getCity(cityIndex);
                /* get next city */
                City destinationCity;

                if (cityIndex + 1 < tourSize()) {
                    destinationCity = getCity(cityIndex + 1);
                } else {
                    destinationCity = getCity(0);
                }
                /* et the distance between the two cities */
                tourDistance += fromCity.calcDitsanceDiff(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }

    /* get number of cities on our tour */
    public int tourSize() {
        return tour.size();
    }

    @Override
    public String toString() {
        String geneString = " >> ";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getCity(i) + " >> ";
        }
        return geneString;
    }
}
