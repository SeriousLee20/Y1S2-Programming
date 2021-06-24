package LabExercise.L13_21;

/*
 * Author: Hui Xin
 * 22 Jun 2021
 */

public class BSTTest {
    public static void main(String[] args) {
        BST<String> l = new BST<>();
        l.insert("0100");
        l.insert("0050");
        l.insert("0150");
        l.insert("0025");
        l.insert("0070");
        l.insert("0001");
        l.insert("0030");
        l.insert("0065");
        l.insert("0085");
        l.insert("0135");
        l.insert("0169");
        l.insert("0180");
        System.out.println("Pre-order");
        l.preorder();
        System.out.println("\nIn-order");
        l.inorder();

        System.out.println("\nPost-order");
        l.postorder();
    }
}
