package PYQ.S1_2017;

/*
 * Author: Hui Xin
 * 22 Jun 2021
 */

public class Queue<Item extends Comparable<Item>> {

    private LinkedList<Item> list = new LinkedList<>();
    private int size;

    public Queue() {
    }

    public Queue(Item[] q) {
        for (Item i : q) {
            list.addLast(i);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Item peek() {
        return list.getFirst();
    }

    public void enqueue(Item data) {
        list.addLast(data);
    }

    public Item dequeue() {
        Item dequeued = list.get(0);
        list.removeFirst();
        return dequeued;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public void ChangeOrder(int k) {

        for (int i = 0; i < k - 1; i++) {
            list.addLast(list.removeFirst());
        }
    }
}
