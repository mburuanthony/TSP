package nondeterministic;

/*class defines a city*/
public class City {
    /* city X and Y coordinates */
    int x, y;

    /* random city constructor */
    public City() {
        this.x = (int) (Math.random() * 100);
        this.y = (int) (Math.random() * 100);
    }

    /* city constructor */
    public City(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /* X coordinate getter method */
    int getX() {
        return this.x;
    }

    /* Y coordinate getter method */
    int getY() {
        return this.y;
    }

    /* calculate distance */
    public double calcDitsanceDiff(City city) {
        int distanceX = Math.abs(getX() - city.getX());
        int distanceY = Math.abs(getY() - city.getY());

        double distance = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
        return distance;
    }

    /* get X,Y coordinates as string */
    public String ToString() {
        return getX() + ", " + getY();
    }
}
