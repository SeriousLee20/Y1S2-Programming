package PYQ.S1_2017;

/*
 * Author: Hui Xin
 * 22 Jun 2021
 */

public class TesterClass {
    public static void main(String[] args) {
        testLinkedList();
    }

    public static void testQueue() {
        Queue<Integer> q = new Queue<>(new Integer[]{10,20,30,40,50,60,70,80,90});
        System.out.println(q);

        q.ChangeOrder(4);
        System.out.println(q);
    }

    public static void testLinkedList() {
        SinglyLinkedListFinals<Integer> s1 = new SinglyLinkedListFinals<>();
        s1.add(10);
        s1.add(20);
        s1.add(30);
        s1.add(40);
        s1.add(50);
        s1.addAfter(11, 10);
        s1.addAfter(21, 20);
        s1.addAfter(31, 30);
        s1.addAfter(41, 40);
        s1.addAfter(51, 50);

        s1.traverse();


        s1.deleteFront();

        s1.deleteFront();

        s1.traverse();

        s1.deleteAfter(40);
        s1.deleteAfter(40);
        s1.deleteAfter(31);
        s1.deleteAfter(40);
        s1.traverse();
    }
}
