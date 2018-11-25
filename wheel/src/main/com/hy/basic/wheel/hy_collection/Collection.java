package com.hy.basic.wheel.hy_collection;



/**
 * Description: 集合框架的基准
 *
 * @author hy
 * Create in 2018/1/9 10:13
 */
public interface Collection<E> extends Iterable<E> {

    /*
        类的泛型作用: 提高通用性,让参数或返回类型确定(而不是Object)
     */

    //增加删除
    boolean add(E e);
    boolean remove(Object o);
    //todo 这里为什么是Object

    //判断大小,非空
    int size();
    boolean isEmpty();

    //哈希码重写,判断相同
    int hashCode();
    boolean contains(Object o);

    //转换为数组
    Object[] toArray();



}
