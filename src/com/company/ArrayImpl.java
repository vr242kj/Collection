package com.company;

import java.util.Iterator;

public class ArrayImpl implements Array {

    private static final int DEFAULT_CAPACITY = 10;
    Object[] array;
    private int size;

    public ArrayImpl(){
       this.array = new Object[DEFAULT_CAPACITY];
    }

    public ArrayImpl(int initialCapacity){
        if (initialCapacity > 0) {
            this.array = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    @Override
    public void clear() {
        for(int i = 0;i<array.length;i++){
            array[i] = null;
        }
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

    private class IteratorImpl implements Iterator<Object> {

        int point = 0;

        @Override
        public boolean hasNext() {
            if(size <= 1|| point == size){
                return false;
            }
            return true;
        }

        @Override
        public Object next() {
            //point++;
            return array[point++];
        }

    }

    @Override
    public void add(Object element) {
       /* size++;
        Object[] arr2 = new Object[size];
        System.arraycopy(array, 0, arr2, 0, size-1);
        arr2[size - 1] = element;
        //System.out.println(arr2[1]);
        this.array = arr2;
        //System.out.println(array[1]);
        //size++;*/
        Object[] arr2 = new Object[size+1];
        System.arraycopy(array, 0, arr2, 0, size);
        arr2[size] = element;
        this.array = arr2;
        size++;
    }

    @Override
    public void set(int index, Object element) {
        array[index] = element;
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public int indexOf(Object element) {
        int index = 0;
        for(int i = 0;i<size;i++) {
            if (array[i] == element) {
            index = i;
            break;
            }else{
                index = -1;
            }
        }
        return index;
    }

    @Override
    public void remove(int index) {
        //size = 1
        if(size < 2) {
            array = null;
            size = 0;
            return;
        }
        Object[] arr2 = new Object[size - 1];
        // A B C
        // 0 1 2
        System.arraycopy(array, 0, arr2, 0, index);
        size--;
        System.arraycopy(array, index + 1, arr2, index, size - index);
        array = arr2;
    }

    @Override
    public String toString() {
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append("[");
        for(int i = 0;i<size;i++){
            if(i==size-1){
                strBuffer.append(array[i]);
                break;
            }
            strBuffer.append(array[i]);
            strBuffer.append(", ");
        }
        strBuffer.append("]");

        return strBuffer.toString();
    }

    public static void main(String[] args) {
        /*ArrayImpl array = new ArrayImpl(10);
        array.add("A");
        array.add("B");
        array.add("C");
        array.add("Q");

        array.add(null);

        Iterator<Object> it = array.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }*/



        //array.remove(2);
        //System.out.println(array.get(0));
        //System.out.println(array.get(1));
        //System.out.println(array.toString());
        //System.out.println(array.indexOf(null));
        //array.add("C");
        //array.add(null);
        //array.clear();
        /*for(int i = 0; i<array.size();i++){
            System.out.println(array.get(i));
        }*/
    }

}
