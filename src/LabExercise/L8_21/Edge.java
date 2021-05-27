package LabExercise.L8_21;

/*
 * Author: Hui Xin
 * 07 May 2021
 */

public class Edge<T extends Comparable<T>, N extends Comparable<N>> {

    // destination vertex of an edge
    Vertex<T, N> dest;

    // weight of the edge
    N weight;

    // other edge connected to a vertex
    Edge<T, N> nextE;

    public Edge() {
        dest = null;
        weight = null;
        nextE = null;
    }

    public Edge(Vertex<T, N> dest, N w, Edge<T, N> nextE) {
        this.dest = dest;
        weight = w;
        this.nextE = nextE;
    }
}
