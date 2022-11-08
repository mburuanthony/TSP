package dynamic;

public class Generic {
    /* parameters */
    private static final double mutationRate = 0.15;
    private static final int tournamentSize = 5;
    private static final boolean elitisim = true;

    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.getPopSize(), false);

        int elitismOffset = 0;
        if (elitisim) {
            newPopulation.saveRoute(0, pop.getBestRoute());

            elitismOffset = 1;
        }

        // Crossover population
        // Loop over the new population's size and create individuals from
        // Current population
        for (int i = elitismOffset; i < newPopulation.getPopSize(); i++) {
            // Select parents
            Route parent1 = tournamentSelection(pop);
            Route parent2 = tournamentSelection(pop);
            // Crossover parents
            Route child = crossover(parent1, parent2);
            // Add child to new population
            newPopulation.saveRoute(i, child);
        }

        // Mutate the new population a bit to add some new genetic material
        for (int i = elitismOffset; i < newPopulation.getPopSize(); i++) {
            mutate(newPopulation.getRoute(i));
        }

        return newPopulation;
    }

    // Applies crossover to a set of parents and creates offspring
    public static Route crossover(Route parent1, Route parent2) {
        // Create new child tour
        Route child = new Route();

        // Get start and end sub tour positions for parent1's tour
        int startPos = (int) (Math.random() * parent1.routeSize());
        int endPos = (int) (Math.random() * parent1.routeSize());

        // Loop and add the sub tour from parent1 to our child
        for (int i = 0; i < child.routeSize(); i++) {
            // If our start position is less than the end position
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setCiy(i, parent1.getCity(i));
            } // If our start position is larger
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setCiy(i, parent1.getCity(i));
                }
            }
        }

        /* Loop through parent2's city route */
        for (int i = 0; i < parent2.routeSize(); i++) {
            /* If child doesn't have the city add it */
            if (!child.routeHasCity(parent2.getCity(i))) {
                /* Loop to find a spare position in the child's tour */
                for (int ii = 0; ii < child.routeSize(); ii++) {
                    /* Spare position found, add city */
                    if (child.getCity(ii) == null) {
                        child.setCiy(ii, parent2.getCity(i));
                        break;
                    }
                }
            }
        }

        return child;
    }

    private static void mutate(Route tour) {
        /* Loop through tour cities */
        for (int tourPos1 = 0; tourPos1 < tour.routeSize(); tourPos1++) {
            if (Math.random() < mutationRate) {
                // Get a second random position in the tour
                int tourPos2 = (int) (tour.routeSize() * Math.random());

                // Get the cities at target position in tour
                City city1 = tour.getCity(tourPos1);
                City city2 = tour.getCity(tourPos2);

                // Swap them around
                tour.setCiy(tourPos2, city1);
                tour.setCiy(tourPos1, city2);
            }
        }
    }

    /* Selects candidate tour for crossover */
    private static Route tournamentSelection(Population pop) {
        /* Create a tournament population */
        Population tournament = new Population(tournamentSize, false);
        /* For each place in the tournament get a random candidate route */
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.getPopSize());
            tournament.saveRoute(i, pop.getRoute(randomId));
        }
        /* Get the best route */
        Route fittest = tournament.getBestRoute();

        return fittest;
    }
}