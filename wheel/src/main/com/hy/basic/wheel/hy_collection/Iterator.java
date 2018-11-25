package com.hy.basic.wheel.hy_collection;

/**
 * Description: 迭代器接口
 *
 * @author hy
 * Create in 2018/1/10 11:13
 */
public interface Iterator<E> {

    boolean hasNext();

    E next();
    //删除为什么不像add
    void remove();

}
