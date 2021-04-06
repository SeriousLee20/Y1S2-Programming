package TutExercise.T4;

/*
 * Author: Hui Xin
 * 04 Apr 2021
 */

import LabExercise.L4_21.Node;

public class Q1 {
    public static void main(String[] args) {

        Node<Character> node1 = new Node<>('a');
        Node<Character> node2 = new Node<>('z');

        node1.setNext(node2);

        Node<Character> firstNode = new Node<>('b');
        firstNode.setNext(node1);

        Node<Character> lastNode = new Node<>('c');

        Node<Character> current = firstNode;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(lastNode);

    }
}
