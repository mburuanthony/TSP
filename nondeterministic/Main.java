package nondeterministic;

/*main class*/
public class Main {
    /* determine acceptance probability */
    public static double acceptanceprobablitiy(int energy, int newEnery, double temperature) {
        if (newEnery < energy) {
            return 1.0;
        }

        return Math.exp((energy - newEnery) / temperature);
    }

    public static void main(String[] args) {
        /* create and add cities */
        City city = new City(60, 200);
        RouteManager.addCity(city);
        City city2 = new City(180, 200);
        RouteManager.addCity(city2);
        City city3 = new City(80, 180);
        RouteManager.addCity(city3);
        City city4 = new City(140, 180);
        RouteManager.addCity(city4);
        City city5 = new City(20, 160);
        RouteManager.addCity(city5);
        City city6 = new City(100, 160);
        RouteManager.addCity(city6);
        City city7 = new City(200, 160);
        RouteManager.addCity(city7);
        City city8 = new City(140, 140);
        RouteManager.addCity(city8);
        City city9 = new City(40, 120);
        RouteManager.addCity(city9);
        City city10 = new City(100, 120);
        RouteManager.addCity(city10);
        City city11 = new City(180, 100);
        RouteManager.addCity(city11);
        City city12 = new City(60, 80);
        RouteManager.addCity(city12);
        City city13 = new City(120, 80);
        RouteManager.addCity(city13);
        City city14 = new City(180, 60);
        RouteManager.addCity(city14);
        City city15 = new City(20, 40);
        RouteManager.addCity(city15);
        City city16 = new City(100, 40);
        RouteManager.addCity(city16);
        City city17 = new City(200, 40);
        RouteManager.addCity(city17);
        City city18 = new City(20, 20);
        RouteManager.addCity(city18);
        City city19 = new City(60, 20);
        RouteManager.addCity(city19);
        City city20 = new City(160, 20);
        RouteManager.addCity(city20);

        /* initial temperature */
        double temp = 10000;
        /* cooling rate */
        double coolingRate = 0.0003;

        Tour currentTour = new Tour();
        currentTour.generateIndividual();

        System.out.println("Initial solution distance:" + currentTour.getDistance());

        Tour bestRoute = new Tour(currentTour.getTour());

        /* Loop until system has cooled */
        while (temp > 1) {
            Tour newSolution = new Tour(currentTour.getTour());

            /* et a random positions in the tour */
            int tourPos1 = (int) (newSolution.tourSize() * Math.random());
            int tourPos2 = (int) (newSolution.tourSize() * Math.random());

            /* get the cities at selected positions in the tour */
            City citySwap1 = newSolution.getCity(tourPos1);
            City citySwap2 = newSolution.getCity(tourPos2);

            /* swap the cities */
            newSolution.setCity(tourPos2, citySwap1);
            newSolution.setCity(tourPos1, citySwap2);

            int currentEnergy = currentTour.getDistance();
            int neighbourEnergy = newSolution.getDistance();

            if (acceptanceprobablitiy(currentEnergy, neighbourEnergy, temp) > Math.random()) {
                currentTour = new Tour(newSolution.getTour());
            }

            /* find best solution found */
            if (currentTour.getDistance() < bestRoute.getDistance()) {
                bestRoute = new Tour(currentTour.getTour());
            }

            /* cool system */
            temp *= 1 - coolingRate;
        }

        System.out.println("Final solution distance: " + bestRoute.getDistance());
        System.out.println("Tour: " + bestRoute);
    }
}
