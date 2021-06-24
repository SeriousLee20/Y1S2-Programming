package PYQ.S2_2017;

/*
 * Author: Hui Xin
 * 24 Jun 2021
 */

import java.util.Stack;

class TestBST {
    public static void main(String[] args) {
        BST<Integer> test = new BST<>();
        test.add(9);
        test.add(3);
        test.add(6);
        test.add(7);
        test.add(4);
        test.add(8);
        test.add(10);
        test.add(34);
        test.add(65);
        test.add(20);
        test.printTreeInOrder();

        System.out.println(test.contains(20));
        System.out.println(test.contains(99));

    }
}
public class BST<E extends Comparable<E>> {

    protected Node<E> root;
    protected int size;

    public BST() {
        root = null;
    }

    public boolean add(E item) {
        Node<E> node = new Node<>(item, null, null);

        if (root == null) {
            root = node;
            size++;
            return true;
        }

        Node<E> current = root;
        Node<E> parent = root;

        while (true) {

            if (item.compareTo(current.element) < 0) {
                if (current.left == null) {
                    current.left = node;
                    break;
                }
                // parent = current;
                current = current.left;
            } else if (item.compareTo(current.element) > 0) {
                if (current.right == null) {
                    current.right = node;
                    break;
                }
                //parent = current;
                current = current.right;
            } else {
                return false; // duplicate element is rejected
            }
        }

        size++;
        return  true;
    }

    public void printTreeInOrder() {
        if (root == null) {
            return;
        }

        // nodes that haven't printed
        Stack<Node> node = new Stack<>();
        Node current = root;

        // when tree is not fully printed
        while (current != null || node.size() > 0) {

            // push the node with value into stack
            // then track if the node has left node
            // if right node from bottom not null, push into stack
            // if no left node, it'll be printed
            // then, it check if it has right node
            while (current != null) {
                node.push(current);
                current = current.left;
            }

            // pop the node from stack to print
            // also to remove printed node
            current = node.pop();
            System.out.print(current.element + " ");

            // null when printing a leaf node
            // will go right node if one exists
            current = current.right;
        }
        System.out.println();
    }

    public boolean contains(E item) {
        if (root == null) {
            return false;
        }

        Node<E> current = root;

        while (current != null) {

            if (item.compareTo(current.element) < 0) {
                current = current.left;
            } else if (item.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }

        return false;
    }
}

class Node<E> {
    E element;
    Node<E> right;
    Node<E> left;

    public Node(E element, Node<E> right, Node<E> left) {
        this.element = element;
        this.right = right;
        this.left = left;
    }

    @Override
    public String toString() {
        return element + " ";
    }
}
