package com.hy.basic.wheel.hy_collection;

/**
 * Description: 数列基准
 *
 * @author hy
 * Create in 2018/1/9 10:23
 */
public interface List<E> extends Collection<E> {

    /*
        这里和collection重复的接口方法是为了在多态时使用
     */

    //CRUD
    boolean add(E e);
    void add(int i, E e);
    boolean remove(Object o);
    E remove(int i);
    E get(int i);
    E set(int i, E e);


    boolean isEmpty();
    boolean contains(Object o);
    //判断实例个数
    int size();
    //查找此对象
    int indexOf(Object o);

    Object[] toArray();

}
