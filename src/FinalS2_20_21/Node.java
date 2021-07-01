package FinalS2_20_21;

/*
 * Author: Hui Xin
 * 25 Jun 2021
 */

public class Node<E> {
    E element;
    Node<E> next;
    public Node(E item) {
        element = item;
        next = null;
    }
}
