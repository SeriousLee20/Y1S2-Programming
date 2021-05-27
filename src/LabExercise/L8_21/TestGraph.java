package LabExercise.L8_21;

/*
 * Author: Hui Xin
 * 08 May 2021
 */

public class TestGraph {
    public static void main(String[] args) {
        Graph<String, Integer> g1 = new Graph<>();

        System.out.println(g1.getInDeg("v1"));

        System.out.println(g1.hasVertex("v1"));
        System.out.println(g1.addVertex("v1"));


    }
}
