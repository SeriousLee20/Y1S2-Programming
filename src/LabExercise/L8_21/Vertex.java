package LabExercise.L8_21;

/*
 * Author: Hui Xin
 * 07 May 2021
 */

public class Vertex<T extends Comparable<T>, N extends Comparable<N>> {
    T vertexInfo;
    int inDeg;
    int outDeg;

    // new independent vertex in graph
    Vertex<T, N> nextV;
    Edge<T, N> firstEdge;   //form edge with other vertex (like next node)

    public Vertex() {
        vertexInfo = null;
        inDeg = 0;
        outDeg = 0;
        nextV = null;
        firstEdge = null;
    }

    public Vertex(T info, Vertex<T, N> nextV) {
        vertexInfo = info;
        inDeg = 0;
        outDeg = 0;
        this.nextV = nextV;
        firstEdge = null;
    }
}
