package TutExercise.T2;

/*
 * Author: Hui Xin
 * 16 Mar 2021
 */

public class Duo<A, B> {

    private A first;
    private B second;

    public Duo(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public void printObj() {
        System.out.println("First: " + first);
        System.out.println("Second: " + second);
    }

    public static void main(String[] args) {

        Duo<String, Integer> sideShape = new Duo<>("FuNnY", 3);
        Duo<Double, Double> points = new Duo<>(23.0, 324.3);

        sideShape.printObj();
        points.printObj();
    }
}
