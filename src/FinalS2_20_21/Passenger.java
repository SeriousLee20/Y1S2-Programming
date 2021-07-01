package FinalS2_20_21;

/*
 * Author: Hui Xin
 * 25 Jun 2021
 */

public class Passenger implements Comparable<Passenger>{
    private String name;
    private String location;

    public Passenger(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public int compareTo(Passenger o) {
        return this.location.compareTo(o.location);
    }

    @Override
    public String toString() {
        return name;
    }
}
