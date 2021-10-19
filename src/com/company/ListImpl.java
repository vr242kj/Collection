package com.company;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ListImpl implements List {

     public int size = 0;
     public Node first;
     public Node last;
     //private Object array[];

    public ListImpl() {
    }

    @Override
    public void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        private Node lastReturned;
        private Node next = first;
        private int nextIndex = 0;


        @Override
        public boolean hasNext() {
            return  nextIndex < size;
                                //3
        }

        @Override
        public Object next() {
            if (!hasNext())
                return -1;
            /*for(int i = 0;i<nextIndex;i++){
                next = next.next;
            }*/
            if(nextIndex == 0){
                nextIndex++;
            return next.item;
            }
            next = next.next;
            nextIndex++;
            return next.item;
        }

    }

    private static class Node {
        Object item;
        Node next;
        Node prev;

        Node(Node prev, Object element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void addFirst(Object element) {
        Node f = first;
        Node newNode = new Node(null, element, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    @Override
    public void addLast(Object element) {
        Node l = last;
        Node newNode = new Node(l,element,null);
        last = newNode;
        if(l == null){
            first = newNode;
        }else{
            l.next = newNode;
        }
        size++;
    }

    @Override
    public void removeFirst() {
        Node f = first;
        Node next = f.next;
        f.item = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
    }

    @Override
    public void removeLast() {
        Node l = last;
        Node prev = l.prev;
        l.item = null;
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
    }

    @Override
    public Object getFirst() {
        Node a = first;
        if(a == null)
            return null;
        return first.item;
    }

    @Override
    public Object getLast() {
        Node b = last;
        if(b == null)
            return null;
        return last.item;
    }

    @Override
    public Object search(Object element) {
        int index = 0;
        if (element == null) {
            for (Node x = first; x != null; x = x.next) {
                if (x.item == null)
                    return null;
                index++;
            }
        } else {
            for (Node x = first; x != null; x = x.next) {
                if (element.equals(x.item))
                    return x.item;
                index++;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        if (element == null) {
            for (Node x = first; x != null; x = x.next) {
                if (x.item == null) {
                    element = x.item;
                    Node next = x.next;
                    Node prev = x.prev;

                    if (prev == null) {
                        first = next;
                    } else {
                        prev.next = next;
                        x.prev = null;
                    }

                    if (next == null) {
                        last = prev;
                    } else {
                        next.prev = prev;
                        x.next = null;
                    }

                    x.item = null;
                    size--;
                    return true;
                }
            }
        } else {
            for (Node x = first; x != null; x = x.next) {
                if (element.equals(x.item)) {
                    element = x.item;
                    final Node next = x.next;
                    final Node prev = x.prev;

                    if (prev == null) {
                        first = next;
                    } else {
                        prev.next = next;
                        x.prev = null;
                    }

                    if (next == null) {
                        last = prev;
                    } else {
                        next.prev = prev;
                        x.next = null;
                    }

                    x.item = null;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        Iterator<Object> i = iterator();
        if (!i.hasNext()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            Object e = i.next();
            sb.append(e);
            if (!i.hasNext()) {
                return sb.append(']').toString();
            }
            sb.append(", ");
        }
    }

    public static void main(String[] args) {
        ListImpl a = new ListImpl();
        a.addLast("A");
        a.addLast("B");
        a.addLast("C");
        System.out.println(a.toString());

        /*Iterator<Object> itr = a.iterator();
        //System.out.println(it.next());
        //System.out.println(it.next());
        while (itr.hasNext())
            System.out.println(itr.next());*/

        //C B A
        //System.out.println(a.toString());
        /*a.removeFirst();
        System.out.println(a.getFirst());*/

    }
}
