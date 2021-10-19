package com.company;

import java.util.Iterator;

public class QueueImpl implements Queue {

    private Object[] arr;      // array to store queue elements
    private int front;      // front points to the front element in the queue
    private int rear;       // rear points to the last element in the queue
    private int capacity;   // maximum capacity of the queue
    private int count;      // current size of the queue

    public QueueImpl(int size)
    {
        arr = new Object[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    public QueueImpl()
    {
        arr = new Object[10];
        capacity = 10;
        front = 0;
        rear = -1;
        count = 0;
    }


    @Override
    public void clear() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
            count = 0;
        }
    }


    @Override
    public int size() {

        return count;

    }

    @Override
    public Iterator<Object> iterator() {

        return new IteratorImpl();
    }

    @Override
    public void enqueue(Object item)
    {
        // check for queue overflow
        if (isFull())
        {

        }

        //System.out.println("Inserting " + item);

        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }
    public Boolean isFull() {
        return (size() == capacity);
    }

    @Override
    public Object dequeue()
    {
        // check for queue underflow
        if (isEmpty())
        {
            return null;
        }

        //System.out.println("Removing " + arr[front]);

        /////front = (front + 1) % capacity;
        ////count--;
        Object[] a= new Object[1];
        a[0] = arr[0];
        Object[] arr2 = new Object[count-1];
        // A B C
        // 0 1 2
        System.arraycopy(arr, 1, arr2, 0, count-1);
        //size--;
        //System.arraycopy(arr, arr.length + 1, arr2, arr.length, arr.length);
        arr = arr2;
        count--;

        return a[0];
    }

    @Override
    public Object top() {
        {
            if (isEmpty())
            {
                return null;
            }
            return arr[front];
        }
    }

    public boolean isEmpty() {

        return size() == 0;
    }



    @Override
    public String toString() {
        Iterator<Object> it = iterator();
        StringBuilder sb = new StringBuilder();
        if (!it.hasNext()) {
            return "[]";
        }

        /*sb.append('[');
        for (;;) {
            Object e = i.next();
            if (e == null) {

                return sb.append("null");
            }
            sb.append(e);
            if (!i.hasNext()) {
                return sb.append(']').toString();
            }
            sb.append(", ");
        }*/
        sb.append("[");
        for (int i = 0; i < count; i++) {
            if (arr[i] == null) {
                sb.append("null");
                continue;
            }
            sb.append("" + arr[i].toString() + "");
            if (i != size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

   /* private static class Node {

        private Object element;
        private Node next;

        public Object getObject() {
            return element;
        }

        public void setObject(Object object) {
            this.element = object;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }*/


    private class IteratorImpl implements Iterator<Object> {

        private int pointer = 0;


        @Override
        public boolean hasNext() {

            return pointer<count;

        }

        @Override
        public Object next() {

            if (!hasNext()) {
                return -1;
            }

        return arr[pointer++];

        }




    }

    public static void main(String[] args) {
        Queue a = new QueueImpl(10);

        a.enqueue("A");
        a.enqueue("B");
        a.enqueue("C");
        a.enqueue(null);
        //a.clear();
        System.out.println(a.dequeue());


        System.out.println(a.toString());
        //a.dequeue();
        //System.out.println(a.dequeue());


}}



