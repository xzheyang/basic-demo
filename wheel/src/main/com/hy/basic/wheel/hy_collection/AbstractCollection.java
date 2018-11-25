package com.hy.basic.wheel.hy_collection;

import java.util.Arrays;


/**
 * Description:     实现collection基本功能的抽象类
 *
 * @author hy
 * Create in 2018/1/9 15:55
 */
public abstract class AbstractCollection<E> implements Collection<E> {


    /*
         这里设计不为抽象方法,因为collection的有些东西不支持remove方法
     */
    public boolean add(E e){
        throw new UnsupportedOperationException();
    }


    public boolean remove(Object o) {
        Iterator<E> it = iterator();

        /*
            判断传递参数是否为空(是为了判断参数是否为空或迭代器里数据为空,发生空指针)
        */
        if(o==null){
            while (it.hasNext())
                if(it.next()==null){
                    it.remove();
                    return true;
                }
        }else{
            while (it.hasNext())
                if (o.equals(it.next())){
                    it.remove();
                    return true;
                }
        }

        return  false;
    }

    public abstract int size();

    public boolean isEmpty(){   return size()==0;   }

    public boolean contains(Object o) {

        Iterator<E> it = iterator();

        if(o==null){
            while (it.hasNext())
                if(it.next()==null)
                    return true;
        }else{
            while (it.hasNext())
                if(o.equals(it.next()))
                    return true;
        }

        return false;
    }

    @Override
    public Object[] toArray(){
        Object[] r = new Object[size()];

        Iterator<E> it = iterator();
        for (int i = 0; i < r.length; i++) {
            if (! it.hasNext())
                return Arrays.copyOf(r, i);
            r[i] = it.next();
        }

        return null;    //以后会用finishToArray方法考虑迭代器返回的元素多于预期
    }


    public String toString() {
        Iterator<E> it = iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }


    public abstract Iterator<E> iterator();


}
