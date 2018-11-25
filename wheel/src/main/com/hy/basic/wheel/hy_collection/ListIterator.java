package com.hy.basic.wheel.hy_collection;

/**
 * Description:
 *
 * @author hy
 * Create in 2018/1/13 14:12
 */
public interface ListIterator<E> extends Iterator<E> {


    void remove();
    void add(E e);
    void set(E e);



    boolean hasNext();
    E next();
    boolean hasPrevious();
    E previous();


    int nextIndex();
    int previousIndex();


}
