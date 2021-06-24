package TutExercise.T4;

/*
 * Author: Hui Xin
 * 04 Apr 2021
 */

import LabExercise.L4_21.ListNode;

public class Q1 {
    public static void main(String[] args) {

        ListNode<Character> listNode1 = new ListNode<>('a');
        ListNode<Character> listNode2 = new ListNode<>('z');

        listNode1.setNext(listNode2);

        ListNode<Character> firstListNode = new ListNode<>('b');
        firstListNode.setNext(listNode1);

        ListNode<Character> lastListNode = new ListNode<>('c');

        ListNode<Character> current = firstListNode;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(lastListNode);

    }
}
