package Hw4_21002139.ex2;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int default_size = 100;

    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    public ArrayQueue() {
        n = default_size;
        queue = (E[]) new Object[default_size];
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return queue[top];
    }

    @Override
    public void enqueue(E element) {
        // TODO Auto-generated method stub
        if (count == n) {
            n *= 2;
            queue = Arrays.copyOf(queue, n);
        }
        //queue[count++] = element; 
        if (count < queue.length) {
            int index = (top + count) % queue.length;
            queue[index] = element;
            count++;
        }
    }

    @Override
    public E dequeue() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            return null;
        }
        // E result = queue[count];
        // queue[count--] = null;
        // return result;
        E result = queue[top];
        queue[top] = null;
        top = (top + 1) % queue.length;
        count--;
        return result;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return count == 0;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new ArrayQueueIterator();
    }

    class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return num < count;
        }

        @Override
        public E next() {
            // TODO Auto-generated method stub
            E data = queue[(current + num) % n];
            num++;
            return data;
        }
    }

    public static void main(String[] args) {
        String[ ] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
        QueueInterface<String> queue = new ArrayQueue<>();
        queue.enqueue(a1[0]);
        queue.enqueue(a1[1]);
        queue.enqueue(a1[2]);
        queue.enqueue(a1[3]);
        queue.enqueue(a1[4]);
        queue.enqueue(a1[5]);

        System.out.println(queue.isEmpty());
        //Iterator<String> iterator = queue.iterator();
        for (String x : queue) {
            System.out.print(x.toString() + " \n");
        }
        // System.out.println(iterator.hasNext());
        // System.out.println(iterator.next());
        // System.out.println(iterator.next());
        // System.out.println(iterator.next());
        // System.out.println(iterator.next());
        // System.out.println(iterator.next());
        // System.out.println(iterator.next());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        Iterator<String> iterator1 = queue.iterator();
        System.out.println(iterator1.hasNext());
        System.out.println(iterator1.next());
        queue.dequeue();
        System.out.println(queue.isEmpty());
    }
}