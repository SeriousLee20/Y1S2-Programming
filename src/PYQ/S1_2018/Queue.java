package PYQ.S1_2018;

/*
 * Author: Hui Xin
 * 24 Jun 2021
 */

import java.util.LinkedList;

class Q2 {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue("hello");
        q.enqueue("all");
        q.enqueue("who");
        q.enqueue("wants");
        q.enqueue("ice cream");
        q.dequeue();
        q.dequeue();
        q.enqueue("1000");
        q.enqueue("2000");
        q.peek();

        q.display();
    }
}
public class Queue {
    private LinkedList<String> list = new LinkedList<>();
    private int maxSize;

    // i
    public Queue(int maxSize) {
        this.maxSize = maxSize;
    }

    // ii
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // iii
    public String peek() {
        if (isEmpty()) {
            return null;
        }

        System.out.println("Peek(): " + list.getFirst());
        return list.getFirst();
    }

    // iv
    public boolean enqueue(String s) {
        if (list.size() == maxSize) {
            System.out.println("The queue is full.");
            return false;
        }
        list.add(s);
        System.out.println("Data " + s + " inserted");
        return true;
    }

    // v
    public String dequeue() {

        if (isEmpty()) {
            return null;
        }

        String temp = list.getFirst();
        list.removeFirst();

        System.out.println("Data " + temp + " has been removed");
        return temp;
    }

    // vi
    public void display() {
        if (isEmpty()) {
            System.out.println("Empty queue.");
            return;
        }

        System.out.println("-".repeat(65));
        System.out.print("|  ");

        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + "  |  ");
        }

        System.out.println("\n" + "-".repeat(65));

        System.out.print("|  ");
        for (String i : list) {
            System.out.print(i + "  |  ");
        }
    }
}
