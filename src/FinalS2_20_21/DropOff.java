package FinalS2_20_21;

/*
 * Author: Hui Xin
 * 25 Jun 2021
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class DropOff {

    private Passenger[] list;
    private int passengerNum;

    public DropOff(Passenger[] list) {
        this.list = list.clone();
        passengerNum = list.length;
    }

    public void dropOff() {

        PriorityQueue<Passenger> dropQ = new PriorityQueue<>();

        Arrays.sort(list);
        System.out.println(Arrays.toString(list));

        for (Passenger i : list) {
            dropQ.offer(i);
        }

        System.out.println("Passenger Drop-off List");

        // dropping off passenger
        while (!dropQ.isEmpty()) {
            Passenger current = dropQ.poll();
            System.out.println(stop(current) + ": " + current.getName());
        }
    }


    // determine where to drop passenger
    public String stop(Passenger passenger) {
        String location = passenger.getLocation();

        double distance = Double.parseDouble(location.replace("Road ", ""));
        double[] stopDistance = {1.2, 2.2, 3.2, 4.2, 5.2};
        String[] stops = {"Stop A", "Stop B", "Stop C", "Stop D", "Stop E"};

        // if distance less than the first stop
        if (distance < stopDistance[0]) {
            return stops[0];
        }

        // if distance longer than last stop
        if (distance > stopDistance[stopDistance.length - 1]) {
            return stops[stops.length - 1];
        }

        int i;
        for (i = 0; i < stopDistance.length; i++) {
            // loop stop when the stop is further than the passenger's stop location
            if (distance < stopDistance[i]) {
                break;
            }
        }

        // determine among two stops, which is nearer
        if (Math.abs(distance - stopDistance[i]) < Math.abs(distance - stopDistance[i - 1])) {
            return stops[i];
        } else {
            return stops[i - 1];
        }
    }

    public static void main(String[] args) {
        Passenger[] list = {new Passenger("Susan", "Road 0.9"), new Passenger("Jack", "Road 5.5"), new Passenger("Benjamin", "Road 1.6"),
                new Passenger("Rachel", "Road 3.8"), new Passenger("Samuel", "Road 4.1"), new Passenger("Kenneth", "Road 2.6")};

        DropOff queue = new DropOff(list);
        queue.dropOff();
    }
}
