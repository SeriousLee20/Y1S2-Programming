package PYQ.S1_2017;

/*
 * Author: Hui Xin
 * 22 Jun 2021
 */

public class SinglyLinkedListFinals<E> {
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;

    public SinglyLinkedListFinals() {
    }

    public void add(E data) {
        ListNode<E> node = new ListNode<>(data);

        System.out.println("Adding " + data);

        if (head == null) {
            head = node;
            tail = head;
            size++;
            return;
        }

        tail.next = node;
        tail = node;
    }

    /**
     * Add new data after an existed data
     * @param data new data
     * @param prev previous data
     */
    public void addAfter(E data, E prev) {

        ListNode<E> current = head;
        ListNode<E> node = new ListNode<>(data);

        ListNode<E> prevNode = getNode(prev);

        if (prevNode == null) {
            System.out.println("Data does not exist.");
            return;
        }

        System.out.println("Adding " + data + " after " + prev);
        node.next = prevNode.next;
        prevNode.next = node;

    }

    public void traverse() {
        System.out.println("\nShowing content of my linked list:");
        ListNode<E> current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("\n");
    }

    public void deleteFront() {
        System.out.println("Deleting front: " + head);
        System.out.println();
        head = head.next;

    }

    public void deleteAfter(E prev) {
        System.out.println("Testing deleteAfter:");
        ListNode<E> prevNode = getNode(prev);

        if (prevNode == null) {
            System.out.println("Element (" + prev + ") not found...");
            return;
        }

        if (prevNode.next == null) {
            System.out.println("No data after " + prev);
            return;
        }

        ListNode<E> after = prevNode.next;
        System.out.print("After " + prev + " is " + after.data);
        System.out.println(". Deleting " + after.data);
        System.out.println();
        prevNode.next = after.next;
    }

    public ListNode<E> getNode(E data) {
        ListNode<E> current = head;

        while (current != null) {
            if (current.data.equals(data)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
