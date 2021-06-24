package PYQ.S1_2017;

/*
 * Author: Hui Xin
 * 22 Jun 2021
 */

public class LinkedList<Item> {
    ListNode<Item> head;
    ListNode<Item> tail;
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    /**Add an element to the tail of list*/
    public void addLast(Item e) {

        ListNode<Item> newListNode = new ListNode<>(e);

        if (tail == null) {
            tail = newListNode;
            head = tail;
            size++;
            return;
        }

        tail.next = newListNode;
        tail = newListNode;
        size++;
    }

    public Item removeFirst() {

        if (head == null) {
            //System.out.println("The list is empty. No element is removed.");
            return null;
        }

        if (head.next == null) {
            Item data = head.data;
            head = null;
            tail = null;
            size = 0;
            return data;
        }

        Item data = head.data;
        head = head.next;
        size--;

        return data;
    }

    /**Return the first element in the list*/
    public Item getFirst() {

        if (head == null) {
            //System.out.println("The list is empty.");
            return null;
        }

        return head.data;
    }

    public Item get(int index) {

        if (head == null) {
            return null;
        }

        if (index == 0) {
            getFirst();
        } else if (index == size - 1) {
            getLast();
        } else if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
            return null;
        }

        ListNode<Item> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    /**Return the last element in the list*/
    public Item getLast() {

        if (head == null) {
            System.out.println("The list is empty");
            return null;
        }

        return tail.data;
    }

    @Override
    public String toString() {
        ListNode<Item> current = head;
        StringBuilder s = new StringBuilder();

        while (current != null) {
            s.append(current.data).append(" ");
            current = current.next;
        }

        return s.toString();
    }
}
