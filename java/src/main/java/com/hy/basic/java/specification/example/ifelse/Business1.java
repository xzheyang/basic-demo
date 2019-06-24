package com.hy.basic.java.specification.example.ifelse;



/**
 * @user hy
 * @date sometime
 * @introduce        IfElseSpec的方法二(多态)的动态类实现子类
 **/
public class Business1 extends Business {

    public Business1(String a,String b) {
        super(TYPE_ONE);
    }

    @Override
    public void doBusiness(String a, String b) {

    }
}
