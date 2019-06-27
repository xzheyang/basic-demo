package com.hy.basic.java.collections;

import com.hy.basic.java.collections.tool.CloneUtils;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @user yang.he
 * @date 2019/6/21
 * @introduce
 **/
public class CollectionsUse {


    public static void cloneSuit() {
        //集合克隆一般是浅克隆,只是克隆数据的地址
        List<String> old = new ArrayList<>();
        List<String> result = new ArrayList<>();

        //系统深度克隆,效率低
        CloneUtils.systemClone(old);
        //序列化深克隆
        CloneUtils.serializeClone(old);
        //beanUtils克隆
        result = new ArrayList<>();
        try {
            BeanUtils.copyProperties(old,result);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    public static void foreachSuit() {
        /*1. list的foreach(Map的mapSet,set的iterator) 不能删元素回报错(因为本质是迭代器[fail-fast机制]),
                而CopyOnWriteArrayList是因为复制了一遍(本质上是操作复制的List,如果删除了元素,iterator还是读老的数据[fail-safe机制])    */

        /*2. Collections.sort()的实现:

         */

    }

    public static void main(String[] args) {

    }


}
