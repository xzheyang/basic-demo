package com.hy.basic.wheel;

import com.hy.basic.wheel.hy_collection.LinkList;


/**
 * Description:
 *
 * @author hy
 * Create in 2018/1/10 12:41
 */
public class collection<E> {



    public static void main(String[] args) {

        /*
        List<String> a = new ArrayList<String>();
        a.add("0");
        a.add("1");
        a.add("2");*/


        /*
           只要删除最后一个,就会报错.用foreach增强就会出错 原因是System.arraycopy完后,在next()方法中出错

        for (String temp : a) {
            if("2".equals(temp)){
                a.remove(temp);
            }
        }
        */

        /*
           List删除操作需要用迭代器

        Iterator it = a.iterator();
        while (it.hasNext()){
            String temp = (String) it.next();
            if("1".equals(temp)){
                it.remove();
                System.out.println("删除"+temp);
            }
        }*/


        /*
        System.out.println(a.toString());


        int i = 0;
        System.out.println(a.get(++i).toString());
        */

        /*
        hy_collection.List list = new hy_collection.ArrayList(20);


        list.add("1");
        list.add("2");
        list.add("3");

        list.remove("2");
        list.set(0,"13");

        System.out.println(list.toString());*/


        LinkList<String> ll = new LinkList<String>();
        ll.add("1");
        ll.add("2");
        ll.add("3");

        ll.remove(1);
        ll.set(1,"11");



        System.out.println(ll.toString());

    }

}
