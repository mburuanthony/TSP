package dynamic;

/*class defines possible routes*/
public class Population {
    Route[] routes;

    /* construct possible route */
    public Population(int popSize, boolean initialize) {
        routes = new Route[popSize];

        if (initialize) {
            for (int i = 0; i < getPopSize(); i++) {
                Route newRoute = new Route();
                newRoute.createRandomRoute();

                saveRoute(i, newRoute);
            }
        }
    }

    /* save a route */
    public void saveRoute(int idx, Route route) {
        routes[idx] = route;
    }

    /* get route from population */
    public Route getRoute(int idx) {
        return (Route) routes[idx];
    }

    /* get best route in population */
    public Route getBestRoute() {
        Route bestRoute = routes[0];

        for (int i = 1; i < getPopSize(); i++) {
            if (bestRoute.getFitness() <= getRoute(i).getFitness()) {
                bestRoute = getRoute(i);
            }
        }

        return (Route) bestRoute;
    }

    /* get population size */
    public int getPopSize() {
        return routes.length;
    }
}