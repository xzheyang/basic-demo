package com.hy.basic.wheel.hy_collection;

import java.util.RandomAccess;

/**
 * Description:
 *
 * @author hy
 * Create in 2018/1/16 14:48
 */
public class LinkList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable  {

    Node<E> first;
    Node<E> last;

    int size;

    /*
            构造方法
     */

    public LinkList(){

    }

    public LinkList(Collection<? extends E> c){
        this();
        addAll(size,c);
    }


    /*
            CRUD
     */

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public void add(int i, E e) {
        checkPositionIndex(i);

        if (i == size)
            linkLast(e);
        else
            linkBefore(i, e);
    }

    @Override
    public E get(int i) {
        return node(i).element;
    }

    @Override
    public E set(int i, E e) {
        checkElementIndex(i);

        Node<E> oldNode = node(i);
        E oldElement = oldNode.element;
        oldNode.element = e;

        return oldElement;
    }

    @Override
    public E remove(int i) {
        checkElementIndex(i);

        return unLink(node(i));
    }

    /** 垃圾
    @Override
    public E set(int i, E e) {
        checkPositionIndex(i);

        Node<E> oldNode = node(i);
        Node<E> preNode = oldNode.pre;
        Node<E> nextNode = oldNode.next;
        Node<E> newNode = new Node<E>(null,e,null);

        //判断first并返回
        if(oldNode.pre == null){
            first = newNode;
            last = newNode;
            return oldNode.element;
        }else{
            newNode.pre = preNode;
            preNode.next = newNode;
        }

        //判断last并处理
        if(nextNode==null){
            last = newNode;
        }else{
            newNode.next = nextNode;
            nextNode.pre = newNode;
        }

        return oldNode.element;
    }**/

    /*
            基础方法
     */

    private void linkFirst(E e){
        Node<E> newNode = new Node(null,e,first);

        first = newNode;
        if(first==null)
            last = newNode;
        else
            first.pre = newNode;


        size++;
    }

    private void linkLast(E e){
        //todo 为啥喜欢用final修饰变量
        Node<E> newNode = new Node(last,e,null);

        if(last == null)
            first = newNode;
        else
            last.next = newNode;

        last = newNode;
        size++;
    }

    private void linkBefore(int index,E e){
        checkElementIndex(index);

        Node<E> oldNode = node(index);
        Node<E> newNode = new Node<E>(oldNode.pre,e,oldNode);

        if(oldNode.pre == null)
            first = newNode;
        else
            oldNode.pre.next = newNode;
        oldNode.pre = newNode;

        size++;
    }

    E unLink(Node<E> oldNode){

        Node<E> preNode = oldNode.pre;
        Node<E> nextNode = oldNode.next;



        //根据情况判断前后节点指向
        if(preNode==null){
            first = nextNode;
        } else{
            preNode.next = nextNode;
            oldNode.pre = null;             //GC
        }

        if(nextNode==null){
            last = preNode;
        } else{
            nextNode.pre = preNode;
            oldNode.next=null;              //GC
        }


        size--;
        return oldNode.element;

    }

    Node<E> node(int index){

        Node<E> node;

        if(index < (size>>1) ){
            node = first;
            for(int i=0;i<index;i++)
                node = node.next;
        }else{
            node = last;
            for(int i=size;i>index+1;i--)
                node = node.pre;
        }
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean addAll(int index,Collection<? extends E> c) {
        checkPositionIndex(index);

        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;

        Node<E> pre,next;

        if(size==index){
            pre = last;
            next = null;
        }else {
            pre = node(index);
            next = pre.next;
        }

        Iterator it = c.iterator();
        while (it.hasNext()){
            Node<E> newNode = new Node<E>(pre, (E) it.next(),null);

            if(pre==null)
                first = pre;
            else
                pre.next = newNode;
            pre = newNode;
        }

        if(next == null)
            last = pre;
        else{
            last.pre = pre;
            pre.next = last;
        }

        size += numNew;

        return true;
    }

    /*
        检测方法
     */

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new RuntimeException("位置错误");
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new RuntimeException("elemnt没有此位置");
    }



    /*
            核心内部类
     */
    private static class Node<E> {
        Node<E> pre;
        Node<E> next;
        E element;

        Node(Node<E> pre,E element,Node<E> next){
            this.pre=pre;
            this.next=next;
            this.element=element;
        }
    }



}
