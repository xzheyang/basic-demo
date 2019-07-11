package com.hy.basic.java.structure.link.doublylink;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @user yang.he
 * @date 2019/7/1
 * @introduce       双向链使用
 **/
public class ILinkedList {

    public static void main(String[] args) {
        LinkedList<Long> link = new LinkedList<>();
        link.add(1L);
        link.add(2L);
        link.add(3L);

        ListIterator<Long> longListIterator = link.listIterator();

        while (longListIterator.hasNext()){
            Long index = longListIterator.next();
            if (index==2){
                longListIterator.remove();
            }
        }

        System.out.println("args = [" + link + "]");

    }

}
