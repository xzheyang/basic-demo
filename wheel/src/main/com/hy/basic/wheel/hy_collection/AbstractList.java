package com.hy.basic.wheel.hy_collection;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * Description: 实现List基准的抽象类
 *
 * @author hy
 * Create in 2018/1/10 15:54
 */
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {

    @Override
    public boolean add(E e) {
       add(size(),e);
       return true;
    }

    public void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public E remove(int i) {
        throw new UnsupportedOperationException();
    }

    public E get(int i) {
        throw new UnsupportedOperationException();
    }

    public E set(int i, E e) {
        throw new UnsupportedOperationException();
    }



    @Override
    public boolean equals(Object obj) {

        return super.equals(obj);
    }

    public int indexOf(Object o) {
        Iterator<E> it = iterator();

        if(o==null){
            int flag = 0;
            while (it.hasNext())
                if(it.next()==null)
                    return flag++;
        }else{
            int flag = 0;
            while (it.hasNext())
                if(o.equals(it.next()))
                    return flag++;
        }

        return -1;
    }


    /*
        修改次数
     */
    protected transient int modCount = 0;

    public Iterator<E> iterator() {
        return new Itr();
    }

    /**
     *  以后迭代器(内部类)分为三种    Itr,SubIterator,ListIterator
     *
     */

    /*
        TODO     用于
     */
    private class Itr implements Iterator<E> {

        int cursor = 0;
        int lastRet = -1;

        int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor!=size();
        }


        public E next() {

            try {
                E result = get(cursor);
                lastRet=cursor;
                ++cursor;

                return result;

            }catch (IndexOutOfBoundsException e){
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        public void remove() {

            if(lastRet<0)
                throw new IllegalStateException();

            checkForComodification();   //检测

            try {
                AbstractList.this.remove(lastRet);
                if (lastRet < cursor)
                    cursor--;
                lastRet = -1;     //TODO 为什么是-1,而不是--lastRet

            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }


        }



        /*
                异常 TODO 有什么用???
         */
        final void checkForComodification() {
            /*
            if (modCount != expectedModCount)
                throw new RuntimeException("ConcurrentModificationException异常"); */
                //todo 自己创立异常
        }

    }





}
