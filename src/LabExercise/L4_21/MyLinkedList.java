package LabExercise.L4_21;

/*
 * Author: Hui Xin
 * 25 Mar 2021
 */

public class MyLinkedList<E> {
    ListNode<E> head;
    ListNode<E> tail;
    private int size = 0;

    public MyLinkedList() {
    }

    public MyLinkedList(ListNode<E> head, ListNode<E> tail) {
        this.head = head;
        this.tail = tail;
    }

    /*public int size() {

        if (head == null) {
            return 0;
        }

        Node<E> current = head;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }*/

    /**Add an element to the head of list*/
    public void addFirst(E e) {

        ListNode<E> newListNode = new ListNode<>(e);

        newListNode.next = head;
        head = newListNode;

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    /**Add an element to the tail of list*/
    public void addLast(E e) {

        ListNode<E> newListNode = new ListNode<>(e);

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

    public void add(int index, E e) {
        ListNode<E> newListNode = new ListNode<>(e);

        if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else if (index < 0 || index >= size) {
            System.out.println("Invalid index. No element is added.");
        } else {

            ListNode<E> current = head;

            for (int i = 1; i < index; i++) {
                current = current.next;
            }

            newListNode.next = current.next;
            current.next = newListNode;
            size++;
        }
    }

    /**Remove the first element in the list*/
    public E removeFirst() {

        if (head == null) {
            System.out.println("The list is empty. No element is removed.");
            return null;
        }

        if (head.next == null) {
            E data = head.data;
            head = null;
            tail = null;
            size = 0;
            return data;
        }

        E data = head.data;
        head = head.next;
        size--;

        return data;
    }

    /**Remove the last element in the list*/
    public E removeLast() {

        if (head == null) {
            System.out.println("The list is empty. No element is removed");
            return null;
        } else if (head.next == null) {
            E data = head.data;

            head = null;
            tail = null;

            size = 0;
            return data;
        }

        ListNode<E> current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        E data = current.next.data;

        tail = current;
        tail.next = null;
        size--;

        return data;
    }

    public E remove(int index) {

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else if (index < 0 || index >= size) {
            System.out.println("Invalid index. No element is removed.");
            return null;
        }

        ListNode<E> current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }

        ListNode<E> temp = current.next;
        current.next = current.next.next;
        size--;

        return temp.data;
    }

    public void add(E e) {
        ListNode<E> newListNode = new ListNode<>(e);

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

    public boolean contains(E e) {

        if (head == null) {
            return false;
        }

        ListNode<E> current = head;

        while (current.next != null) {

            if (current.equals(e)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public E get(int index) {

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

        ListNode<E> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    /**Return the first element in the list*/
    public E getFirst() {

        if (head == null) {
            System.out.println("The list is empty.");
            return null;
        }

        return head.data;
    }

    /**Return the last element in the list*/
    public E getLast() {

        if (head == null) {
            System.out.println("The list is empty");
            return null;
        }

        return tail.data;
    }

    public int indexOf(E e) {

        if (head == null) {
            System.out.println("The list is empty.");
            return -1;
        }

        ListNode<E> current = head;
        int index = 0;

        while (current.next != null) {

            if (current.equals(e)) {
                return index;
            }
            current = current.next;
            index++;
        }

        System.out.println("Element was not found.");
        return -1;
    }

    public int lastIndexOf(E e) {

        if (head == null) {
            System.out.println("The list is empty.");
            return -1;
        }

        ListNode<E> current = head;
        int currentIndex = 0;
        int lastIndex = -1;

        while (current.next != null) {
            if (current.equals(e)) {
                lastIndex = currentIndex;
            }

            current = current.next;
            currentIndex++;
        }

        return lastIndex;
    }

    /**Replace the element at the specified position in this
       list with the specified element
     * @return element that is replaced*/
    public E set(int index, E e) {

        ListNode<E> newListNode = new ListNode<>(e);

        if (head == null) {
            newListNode.next = null;
            head = newListNode;
            tail = head;
            return null;
        }

        E data;
        if (index == 0) {
            data = head.data;
            newListNode.next = head.next;
            head = newListNode;
        } else if (index == size - 1) {
            ListNode<E> current = head;

            // size - 1 = tail
            // size - 2 = one node before tail
            for (int i = 1; i < size - 1; i++) {
                current = current.next;
            }

            data = current.next.data;

            newListNode.next = null;
            current.next = newListNode;
            tail = newListNode;

            return data;
        } else {
            ListNode<E> current = head;

            for (int i = 1; i < index; i++) {
                current = current.next;
            }

            data = current.next.data;

            newListNode.next = current.next.next;
            current.next = newListNode;
        }

        return data;
    }

    public void clear() {
        head = null;
    }

    public void print() {

        if (head == null) {
            System.out.println("The list is empty.");
        } else {
            ListNode<E> current = head;

            while (current != null) {
                System.out.print(current.data +" ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public void reverse() {

        if (head == null) {
            System.out.println("Enmpty list.");
            return;
        }

        ListNode<E> current = head;
        ListNode<E> next = null;
        ListNode<E> prev = null;

        while (current != null) {

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;

        current = head;

        while (current.next != null) {
            current = current.next;
        }

        tail = current;
    }

    public E getMiddleValue() {

        if (head == null) {
            System.out.println("Empty list.");
            return null;
        }

        if (size == 1) {
            return head.data;
        }

        ListNode<E> current = head;
        E data;
        if (size % 2 == 0) {
            for (int i = 0; i < size / 2 - 1; i++) {
                current = current.next;
            }
            return current.data;
        } else {
            for (int i = 0; i < size / 2; i++) {
                current = current.next;
            }
            return current.data;
        }
    }
}
