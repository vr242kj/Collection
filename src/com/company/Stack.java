package com.company;

public interface Stack extends Container {

    /**
     * Pushes the specified element onto the top.
     *
     * @param element
     */
    void push(Object element);

    /**
     * Removes and returns the top element.
     *
     * @return
     */
    Object pop();

    /**
     * Returns the top element.
     *
     * @return
     */
    Object top();

}
