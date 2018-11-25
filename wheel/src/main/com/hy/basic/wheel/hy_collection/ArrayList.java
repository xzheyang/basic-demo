package com.hy.basic.wheel.hy_collection;

import java.util.Arrays;
import java.util.RandomAccess;

/**
 * Description: 基于数组的无序List
 *
 * @author hy
 * Create in 2018/1/9 10:12
 */

public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

    private static final long serialVersionUID = 8683656581122892189L;

    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULT_EMPTY_ELEMENTDATA = {};

    transient Object[] elementData;

    /*
            三个构造方法
     */
    public ArrayList(){
        elementData = DEFAULT_EMPTY_ELEMENTDATA;
    }

    public ArrayList(int capacity){
        if(capacity>0)
            elementData = new Object[capacity];
        else if(capacity==0)
            elementData = EMPTY_ELEMENTDATA;
        else
            throw new RuntimeException("容量定义错误");

    }

    public ArrayList(Collection<? extends E> collection){
        elementData = collection.toArray();

        if ((size = elementData.length) != 0) {
            if (elementData.getClass() != Object[].class)
                elementData = Arrays.copyOf(elementData, size, Object[].class);
        } else {
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    /*
            判断是否增长容量
     */

    public void ensureCapatiy(int capatiy){
        if(elementData.length<capatiy)
            grow(capatiy);
    }

    /*
            增长容量的方法
     */

    public static final int MAX_CAPATIY = Integer.MAX_VALUE-8;

    public void grow(int capatiy){
        int result = capatiy+capatiy>>1;
        if(MAX_CAPATIY<result)
            elementData = Arrays.copyOf(elementData,result);
        else
            elementData = Arrays.copyOf(elementData,capatiy);
    }

    /*
            CRUD
     */

    @Override
    public boolean add(E e) {

        ensureCapatiy(size+1);

        elementData[size++]=e;
        return true;
    }

    @Override
    public void add(int i, E e) {

        rangeCheckForAdd(i);
        ensureCapatiy(i);

        if(size()>=i){
            System.arraycopy(elementData,i,elementData,i+1,size-i);
            elementData[i] = e;
            size++;
        }

    }

    @Override
    public E get(int i) {
        rangeCheck(i);

        return (E) elementData[i];
    }

    @Override
    public E set(int i, E e) {
        rangeCheck(i);

        E oldValue = (E) elementData[i];
        elementData[i] = e;

        return oldValue;
    }

    @Override
    public E remove(int i) {
        rangeCheck(i);

        E oldValue = (E) elementData[i];
        System.arraycopy(elementData,i+1,elementData,i,size-i-1);
        elementData[--size]=null;

        return oldValue;
    }

    /*
            检测方法
     */

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new RuntimeException("插入位置不能小于0或大于size");
    }

    private void rangeCheck(int index){
        if (index >= size || index < 0)
            throw new RuntimeException("不在范围内");
    }


    /*

     */

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
       return Arrays.copyOf(elementData,size);
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }


}
