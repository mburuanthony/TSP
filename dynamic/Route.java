package dynamic;

import java.util.ArrayList;
import java.util.Collections;

/*class defines routes*/
public class Route {
    /* create list to hold routes to cities */
    private ArrayList<City> routes = new ArrayList<City>();

    private int distance = 0;
    private double fitness = 0;

    /* create empty route/tour */
    public Route() {
        for (int i = 0; i < TourManager.numberOfCities(); i++) {
            routes.add(null);
        }
    }

    /* route constructor */
    public Route(ArrayList<City> routes) {
        this.routes = routes;
    }

    /* create random route */
    public void createRandomRoute() {
        for (int cityidx = 0; cityidx < TourManager.numberOfCities(); cityidx++) {
            setCiy(cityidx, TourManager.getCity(cityidx));
        }

        /* shuffle/reorder routes randomly */
        Collections.shuffle(routes);
    }

    /* get city from route */
    public City getCity(int cityIdx) {
        return (City) routes.get(cityIdx);
    }

    /* set city in a position within route */
    public void setCiy(int cityIdx, City city) {
        routes.set(cityIdx, city);

        /* reset distance & fitness to 0 */
        distance = 0;
        fitness = 0;
    }

    /* get fitness value */
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1 / (double) getDistance();
        }

        return fitness;
    }

    /* get total distance */
    public int getDistance() {
        if (distance == 0) {
            int routeDistance = 0;

            for (int cityidx = 0; cityidx < routeSize(); cityidx++) {
                /* get previous city */
                City prevCity = getCity(cityidx);

                /* get next city */
                City nxtCity;
                if (cityidx + 1 < routeSize()) {
                    nxtCity = getCity(cityidx);
                } else {
                    nxtCity = getCity(0);
                }

                /* get distance difference between previous & next cities */
                routeDistance += prevCity.calcDitsanceDiff(nxtCity);
            }

            distance = routeDistance;
        }

        return distance;
    }

    /* get route size */
    public int routeSize() {
        return routes.size();
    }

    /* check if route has city */
    public boolean routeHasCity(City city) {
        return routes.contains(city);
    }

    /* get cities in routes as string seperated by a >> */
    public String toString() {
        String routeStr = ">> ";

        for (int i = 0; i < routeSize(); i++) {
            routeStr += getCity(i) + " >> ";
        }

        return routeStr;
    }
}