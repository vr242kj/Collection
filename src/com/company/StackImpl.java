package com.company;

import java.util.Iterator;

public class StackImpl implements Stack {

    private Node top;
    private int size;
    private Object[] arr = {};


    public StackImpl() {
        top = null;
        size = 0;
    }
    public StackImpl(int m) {
        //this.size = m;
        arr = new Object[m];

    }

    @Override
    public void clear() {

        arr = new Object[] {};
        size = 0;

    }


    @Override
    public int size() {
        return size;
    }


    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }




    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
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


    @Override
    public void push(Object element) {
        Object[] arr2 = new Object[size + 1];
        System.arraycopy(arr, 0, arr2, 0, size);
        arr2[size] = element;
        arr = arr2;

        Node nod = new Node();
        nod.setElement(element);
        nod.setNext(top);
        top = nod;
        size++;

    }


    @Override
    public Object pop() {
        if (top == null|| size == 0) {
            return null;
        }

        Object[] arr2 = new Object[size-1];
        // A B C
        // 0 1 2
        System.arraycopy(arr, 0, arr2, 0, size-1);
        //size--;
        //System.arraycopy(arr, arr.length + 1, arr2, arr.length, arr.length);
        arr = arr2;

        Object obj = top.getElement();
        top = top.getNext();
        size--;
        return obj;
    }


    @Override
    public Object top() {
        /*if (isEmpty()) {
            return -1;
        }*/
        return top.getElement();
    }


    /*public boolean isEmpty() {
        return (top == null);
    }*/

    private class IteratorImpl implements Iterator<Object> {

        private int pointer = size;

        public boolean hasNext() {
            return (pointer > 0);

        }

        public Object next() {
            if (!hasNext()) {
                return -1;            }

            pointer--;
            return arr[pointer];
        }

    }

    private static class Node {

        private Object element;

        private Node next;

        public Node() {

        }

        public Node(Object element, Node next) {
            this.next = next;
            this.element = element;
        }

        public Object getElement() {
            return element;
        }

        public Node getNext() {
            return next;
        }

        public void setElement(Object element) {
            this.element = element;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    public static void main(String[] args) {
        Stack stack = new StackImpl();
        /*stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push(null);*/
        stack.pop();
        //stack.pop();

        System.out.println(stack.size());
        //stack.clear();
        //System.out.println(stack.size());


        System.out.println(stack);
        Iterator<Object> it = stack.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}