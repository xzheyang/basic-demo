package com.hy.basic.java.collections.tool;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @user yang.he
 * @date 2019/6/21
 * @introduce
 **/
public class CloneUtils {

    public static <T> List<T> systemClone(List<T> old) {
        if (old==null)
            throw new RuntimeException("克隆集合为空");

        List<T> systemNew = new ArrayList<>();
        System.arraycopy(old,0,systemNew,0,old.size());

        return systemNew;
    }

    //序列化克隆 深克隆
    public static <T> List<T> serializeClone(List<T> src)
    {
        List<T> dest = null;
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(src);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            dest = (List<T>) in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return dest;
    }

}
