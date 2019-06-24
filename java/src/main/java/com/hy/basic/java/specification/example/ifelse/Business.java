package com.hy.basic.java.specification.example.ifelse;

/**
 * @user hy
 * @date sometime
 * @introduce        IfElseSpec的方法二(多态)的多态动态父类
 **/
public abstract class Business {

    private Integer type;
    public static Integer TYPE_ONE = 1;
    public static Integer TYPE_TWO = 2;

    public Business(int type){
        this.type=type;
    }

    public abstract void doBusiness(String a,String b);

}
