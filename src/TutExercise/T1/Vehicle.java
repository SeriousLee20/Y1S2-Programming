package TutExercise.T1;

/*
 * Author: Hui Xin
 * 11 Mar 2021
 */

public abstract class Vehicle {
    private double maxSpeed;
    protected double currentSpeed;

    public Vehicle(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public abstract void accelerate();

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void pedalToTheMetal() {

        if (currentSpeed == maxSpeed) {
            System.out.println("Reach the max speed");
        }
    }
}
