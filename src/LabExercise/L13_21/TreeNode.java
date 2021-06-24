package LabExercise.L13_21;

/*
 * Author: Hui Xin
 * 21 Jun 2021
 */

public class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(E element) {
        this.element = element;
        left = right = null;
    }
}
