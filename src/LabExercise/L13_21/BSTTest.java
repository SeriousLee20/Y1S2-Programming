package LabExercise.L13_21;

/*
 * Author: Hui Xin
 * 22 Jun 2021
 */

public class BSTTest {
    public static void main(String[] args) {
        BST<String> l = new BST<>();
        l.insert("40");
        l.insert("26");
        l.insert("18");
        l.insert("32");
        l.insert("34");
        l.insert("38");
        l.insert("45");
        l.insert("43");
        l.insert("41");
        //l.insert("0135");
        //l.insert("0169");
        //l.insert("0180");
        System.out.println("Pre-order");
        l.preorder();
        System.out.println("\nIn-order");
        l.inorder();

        System.out.println("\nPost-order");
        l.postorder();
    }
}
