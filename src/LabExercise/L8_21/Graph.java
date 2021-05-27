package LabExercise.L8_21;

/*
 * Author: Hui Xin
 * 07 May 2021
 */

import java.util.ArrayList;

public class Graph<T extends Comparable<T>, N extends Comparable<N>> {

    Vertex<T, N> head;
    int size;

    public Graph() {
        head = null;
        size = 0;
    }

    /**@return number of vertices*/
    public int getSize() {
        return size;
    }

    /**check the existence of the vertex*/
    public boolean hasVertex(T v) {
        //isEmpty();

        Vertex<T, N> temp = head;

        while (temp != null) {
            if (temp.vertexInfo.equals(v)) {
                return true;
            }

            temp = temp.nextV;
        }
        return false;
    }

    /**Get inDeg of a vertex*/
    public int getInDeg(T v) {
        //isEmpty();

        Vertex<T, N> temp = head;

        while (temp != null) {

            if (temp.vertexInfo.equals(v)) {
                return temp.inDeg;
            }

            temp = temp.nextV;
        }

        return -1;
    }

    /**Add new vertex to the graph*/
    public boolean addVertex(T v) {

        //vertex not exist, add vertex
        if (!hasVertex(v)) {

            Vertex<T, N> newV = new Vertex<>(v, null);

            Vertex<T, N> temp = head;

            if (isEmpty()) {
                head = newV;
            } else {

                // loop until last vertex
                while (temp.nextV != null) {
                    temp = temp.nextV;
                }

                temp.nextV = newV;
            }
            size++;
            return true;
        }

        // vertex existed
        return false;
    }

    /**@return index of vertex in graph*/
    public int getIndex(T v) {
        Vertex<T, N> temp = head;

        int pos = 0;
        while (temp != null) {
            if (temp.vertexInfo.equals(v)) {
                return pos;
            }

            temp = temp.nextV;
            pos++;
        }
        return -1;
    }

    /**@return an ArrayList with info of all vertices*/
    public ArrayList<T> getAllVertexObjects() {
        ArrayList<T> list = new ArrayList<>();

        Vertex<T, N> temp = head;

        while ((temp != null)) {
            list.add(temp.vertexInfo);
            temp = temp.nextV;
        }
        return list;
    }

    /**@return info of an vertex at a position*/
    public T getVertex(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid index");
            return null;
        }

        Vertex<T, N> temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.nextV;
        }

        return temp.vertexInfo;
    }

    /**Check if an edge exist from source vertex to dest vertex*/
    public boolean hasEdge(T source, T dest) {
        if (isEmpty()) {
            return false;
        }

        Vertex<T, N> sourceV = head;

        while (sourceV != null) {
            if (sourceV.vertexInfo.equals(source)) {

                // reached sourceV
                // find destV (one of the edge from sourceV)
                // NOTE: not path
                Edge<T, N> currentE = sourceV.firstEdge;

                while (currentE != null) {

                    // found destV
                    if (currentE.dest.vertexInfo.equals(dest)) {
                        return true;
                    }
                    currentE = currentE.nextE;
                }
            }

            sourceV = sourceV.nextV;
        }
        return false;
    }

    /**Add a weighted edge from source to dest*/
    public boolean addEdge(T source, T dest, N w) {
        if (isEmpty()) {
            return false;
        }

        Vertex<T, N> sourceV = head;

        while (sourceV != null) {

            if (sourceV.vertexInfo.equals(source)) {

                // found sourceV
                Vertex<T, N> destV = head;

                while (destV != null) {

                    // found destV
                    if (destV.vertexInfo.equals(dest)) {

                        // get the ori vertex connected as firstEdge
                        Edge<T,N> currentE = sourceV.firstEdge;

                        // original edge is made as next edge
                        // new edge formed between sourceV and destV
                        sourceV.firstEdge = new Edge<>(destV, w, currentE);
                        sourceV.outDeg++;
                        destV.inDeg++;
                        return true;
                    }

                    destV = destV.nextV;
                }
            }

            sourceV = sourceV.nextV;
        }

        // sourceV not found || destV not found
        return false;
    }

    /**@return weight of an edge from source to dest*/
    public N getEdgeWeight(T source, T dest) {

        if (isEmpty()) {
            return null;
        }

        Vertex<T,N> sourceV = head;
        while (sourceV != null) {
            if (sourceV.vertexInfo.equals(source)) {

                // reached sourceV
                // find destV (one of the edge from sourceV)
                // NOTE: not path
                Edge<T,N> currentE = sourceV.firstEdge;

                while (currentE != null) {

                    if (currentE.dest.vertexInfo.equals(dest)) {

                        return currentE.weight;
                    }
                    currentE = currentE.nextE;
                }
            }

            sourceV = sourceV.nextV;
        }

        // edge not found
        return null;
    }

    /**@return an ArrayList with all neighbours of a vertex*/
    public ArrayList<T> getNeighbours(T v) {
        if (isEmpty()) {
            return null;
        }

        ArrayList<T> neighbours = new ArrayList<>();
        Vertex<T,N> temp = head;

        while (temp != null) {
            if (temp.vertexInfo.equals(v)) {

                Edge<T,N> currentE = temp.firstEdge;

                while (currentE != null) {
                    neighbours.add(currentE.dest.vertexInfo);
                    currentE = currentE.nextE;
                }
            }

            temp = temp.nextV;
        }

        return neighbours;
    }

    /**Print graph*/
    public void printEdges() {
        if (isEmpty()) {
            System.out.println("Empty graph");
        } else {

            Vertex<T, N> currentV = head;

            while (currentV != null) {
                System.out.print(currentV.vertexInfo + " connected to ");

                Edge<T, N> currentEdge = currentV.firstEdge;

                while (currentEdge != null) {
                    System.out.print(currentEdge.dest.vertexInfo + " ");
                    currentEdge = currentEdge.nextE;
                }
                System.out.println();
                currentV = currentV.nextV;
            }
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}
