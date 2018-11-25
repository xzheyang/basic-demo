package com.hy.basic.java.reflect.proxy;

import com.hy.basic.java.reflect.proxy.eg.classExample;
import com.hy.basic.java.reflect.proxy.eg.interfaceExample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxy {


    //简单使用动态代理(需要被代理类有接口)
    public Object createProxyExample(){

        //创建实例
        classExample eg = new classExample();

        //创建代理类
        return Proxy.newProxyInstance(classExample.class.getClassLoader(),eg.getClass().getInterfaces(),new InvocationHandler() {
            /*
             * proxy：把代理对象自身传递进来
             * method：代表当前调用的方法
             * args：当前调用方法的参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //在这里面编写代码来指定产生的代理对象干什么事情...
                String methodName = method.getName();
                if("method1".equals(methodName)){
                   return method.invoke(eg,args);
                }else if ("method2".equals(methodName)){
                    return method.invoke(eg,args);
                }else {
                    System.out.println("没有这个方法");
                    return null;
                }

            }
        });


    }

    public static void main(String[] args) {


        proxy p = new proxy();
        interfaceExample ie = (interfaceExample) p.createProxyExample();
        ie.method1();

    }


}
