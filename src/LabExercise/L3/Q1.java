package LabExercise.L3;

/*
 * Author: Hui Xin
 * 21 Feb 2021
 */

public class Q1 {

    static class MeshTopology {

        public MeshTopology() {
            System.out.println("Mesh Topology");
        }

        public int numOfConnections(int switches) {

            if (switches > 0) {
                return switches - 1 + numOfConnections(switches - 1);
            } else {
                return 0;
            }
        }

        public void displayNumOfConnections(int switches) {
            System.out.println("There are " + switches + " switches in the campus.");
            System.out.println("The total number of connections required is " + numOfConnections(switches));
        }
    }

    public static void main(String[] args) {
        MeshTopology mt = new MeshTopology();

        mt.displayNumOfConnections(4);
        mt.displayNumOfConnections(7);
    }
}
