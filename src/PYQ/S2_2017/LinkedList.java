package PYQ.S2_2017;

/*
 * Author: Hui Xin
 * 24 Jun 2021
 */

import java.text.DecimalFormat;

class Q1 {
    public static void main(String[] args) {

        LinkedList l = new LinkedList();
        l.insertFirstLink("Louis Vuitton", 10000000);
        l.insertFirstLink("Chanel", 100000000);
        l.insertFirstLink("Prada", 1000000);
        l.insertFirstLink("Tods", 500000000);
        l.display();

        l.addAfter("Chanel", "Coach", 10000000);
        l.display();

        l.addAfter("Coach", "Mulberry", 90000000);
        l.display();

        l.removeLink("Chanel");
        l.display();
        l.removeLink("Coach");
        l.display();

    }
}

public class LinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;

    public LinkedList() {
    }

    //i
    public void insertFirstLink(String brands, int amount) {
        ListNode node = new ListNode(brands, amount);

        if (head == null) {
            head = node;
            tail = head;
            size++;
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
        size++;
    }

    // ii
    public boolean addAfter(String prevBrand, String newBrand, int amount) {

        ListNode current = head;
        int count = 1;
        ListNode node = new ListNode(newBrand, amount);

        System.out.println("Adding " + newBrand + " after " + prevBrand);

        while (current != null) {
            if (current.getBrands().equals(prevBrand)) {
                System.out.println("Found " + prevBrand + " which is handbag number " + count + " in the linked list\n");
                if (current.next == null) {
                    current.next = node;
                    tail = node;
                    size++;
                    return true;
                }

                node.next = current.next;
                current.next = node;
                size++;
                return true;
            }
            current = current.next;
            count++;

        }

        System.out.println(prevBrand + " not found.");
        return false;
    }

    // iii
    public boolean removeLink(String brand) {

        ListNode current = head;
        int count = 1;

        System.out.println("Removing " + brand);

        if (head.getBrands().equals(brand)) {
            System.out.println("Found a match.. " + brand + " is handbag number " + count + " in the linked list\n");

            head = head.next;
            size--;
            return true;
        }
        while (current.next != null) {
            count++;
            if (current.next.getBrands().equals(brand)) {

                System.out.println("Found a match.. " + brand + " is handbag number " + count + " in the linked list\n");

                current.next = current.next.next;

                if (current.next == null) {
                    tail = current;
                }

                size--;
                return true;
            }

            current = current.next;
        }

        System.out.println(brand + " not found.");
        return false;
    }

    // iv
    public void display() {
        if (head == null) {
            System.out.println("Empty list.");
            return;
        }

        System.out.println("Displaying the Linked List *******************************");
        ListNode current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
        System.out.println();
    }
}

class ListNode {
    private String brands;
    private int amount;
    ListNode next;

    public ListNode() {
    }

    public ListNode(String brands, int amount) {
        this.brands = brands;
        this.amount = amount;
        this.next = null;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public String getBrands() {
        return brands;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###,###");
        return brands + ": " + df.format(amount) + " Sold";
    }
}

