package PYQ.S1_2018;

/*
 * Author: Hui Xin
 * 24 Jun 2021
 */

class Q3 {
    public static void main(String[] args) {
        Stack<String> test = new Stack<>(4);
        test.push("one");
        test.push("two");
        test.push("three");
        test.push("four");
        test.displayInReverse();
        test.popAll();
        test.displayInReverse();

        Stack<Integer> test2 = new Stack<>(4);
        test2.push(100);
        test2.push(200);
        test2.push(300);
        test2.push(400);

        System.out.println(test2.peek());
        test2.display();
        test2.displayInReverse();
        test2.popAll();
    }
}
public class Stack<E> {
    private StackNode<E> head;
    private int size;
    private int maxSize;

    // i
    public Stack(int maxSize) {
        this.maxSize = maxSize;
    }

    // ii
    public boolean isEmpty() {
        return head == null;
    }

    // iii
    public E peek() {
        if (isEmpty()) {
            return null;
        }

        StackNode<E> current = head;

        while (current.getNext() != null) {
            current = current.getNext();
        }

        return current.getData();
    }

    // iv
    public boolean push(E data) {
        StackNode<E> node = new StackNode<>(data);

        System.out.println("Push item into stack: " + data);

        if (isEmpty()) {
            head = node;
            size++;
            return true;
        }

        if (size == maxSize) {
            System.out.println("Stack is full");
            return false;
        }

        StackNode<E> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(node);
        size++;
        return true;
    }

    // v
    public E pop() {
        if (isEmpty()) {
            return null;
        }

        StackNode<E> current = head.getNext();
        StackNode<E> prev = head;

        if (current == null) {
            E temp = head.getData();
            head = null;
            size = 0;
            System.out.println("Removing " + temp + " ..");
            return temp;
        }

        while (current.getNext() != null) {
            prev = current;
            current = current.getNext();
        }

        prev.setNext(null);
        size--;
        System.out.println("Removing " + current.getData() + " ..");

        return current.getData();
    }

    // vi
    public void popAll() {

        if (isEmpty()) {
            return;
        }

        System.out.println("Pop all item in stack:");

        while (!isEmpty()) {
            pop();
        }
    }

    // vii
    public void display() {
        if (isEmpty()) {
            System.out.println("Empty stack.");
            return;
        }

        StackNode<E> current = head;

        System.out.println("Display stack: ");

        for (int i = 0; i < maxSize; i++) {
            System.out.println(current);

            if (current != null) {
                current = current.getNext();
            }
        }
    }

    // viii
    public void displayInReverse() {

        StackNode<E> current = head;
        StackNode[] nodes = new StackNode[maxSize];

        for (int i = 0; i < maxSize; i++) {
            nodes[i] = current;

            if (current != null) {
                current = current.getNext();
            }
        }


        System.out.println("Display stack in reverse:");

        for (int i = nodes.length - 1; i > -1; i--) {
            System.out.println(nodes[i]);
        }
    }
}

class StackNode<E> {

    private E data;
    private StackNode<E> next;

    public StackNode(E data) {
        this.data = data;
        this.next = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public StackNode<E> getNext() {
        return next;
    }

    public void setNext(StackNode<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data + "";
    }
}
