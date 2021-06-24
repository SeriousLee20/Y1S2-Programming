package PYQ.S2_2017;

/*
 * Author: Hui Xin
 * 24 Jun 2021
 */

import java.util.LinkedList;
import java.util.Scanner;

// (a)
public class Queue<E> {
    private LinkedList<E> list = new LinkedList<>();
    private int size;

    // ii
    public Queue() {
    }

    // i
    public Queue(E[] items) {
        for (E i : items) {
            list.add(i);
        }
        size = list.size();
    }

    // iii
    public void enqueue(E e) {
        list.add(e);
        size++;
    }

    // iv
    public E dequeue() {
        E temp = list.getFirst();
        list.removeFirst();
        size--;
        return temp;
    }

    // v
    public E getElement(int i) {
        return list.get(i);
    }

    // vi
    public int getSize() {
        return size;
    }

    // vii
    public boolean isEmpty() {
        return size == 0;
    }

    // viii
    public String toString() {

        return list.toString();
    }
}

class TestQueue {
    public static void main(String[] args) {

        Character[] alphabet = new Character[26];
        Queue<Integer> index = new Queue<>();

        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a' + i);
            index.enqueue(i);
        }

        Queue<Character> alpha = new Queue<>(alphabet);

       decipher(alpha, index);
    }

    public static void decipher(Queue<Character> alpha, Queue<Integer> index) {
        Scanner in = new Scanner(System.in);

        System.out.println("Queue: " + alpha);
        System.out.println("Index: " + index);

        System.out.print("How many times will you enter a number: ");
        int freq = in.nextInt();

        System.out.println("(Please enter your number(s) between 0-26");
        Queue<Integer> entered = new Queue<>();

        for (int i = 0; i < freq; i++) {
            System.out.print("Enter number " + (i + 1) + " >> ");
            entered.enqueue(in.nextInt());
        }

        System.out.println("The entered numbers are " + entered);

        if (entered.isEmpty()) {
            System.out.println("The deciphered values are -Cannot decipher. No value was entered.-");

        } else {

            StringBuilder s = new StringBuilder();

            while (!entered.isEmpty()) {
                int current = entered.dequeue();
                s.append(alpha.getElement(current));
            }

            System.out.println("The deciphered values are " + s);
        }
    }
}