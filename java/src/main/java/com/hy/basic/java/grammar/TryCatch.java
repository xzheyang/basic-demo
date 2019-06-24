package com.hy.basic.java.grammar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @user hy
 * @date sometime
 * @introduce            try catch的规范与用法
 **/
public class TryCatch {


    /*
         1.return和finally到底谁先执行:

            finally总会执行,而且finally里面有return时,前面的执行到的return不会执行
           //总结:
           在执行时，是return语句先把返回值写入但内存中，然后停下来等待finally语句块执行完，return再执行后面的一段。


     */


    //老的关闭资源方式
    public static void old() {

        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream(new File("test"));
            System.out.println(inputStream.read());
        } catch (Exception e) {
            e.printStackTrace(); // 第一处异常处理
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace(); // 第二处异常处理
            }
        }

    }


    public static void now() {

        //JDK1.7后出现了语法糖,这里会自动关闭try里面的资源
        try (FileInputStream inputStream = new FileInputStream(new File("test"))) {
            System.out.println(inputStream.read());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }

}
