package com.hy.basic.java.specification;

import com.hy.basic.java.specification.example.ifelse.Business;

/**
 * @user hy
 * @date sometime
 * @introduce            避免if else 嵌套三层以上导致逻辑复杂
 **/
public class IfElseSpec {

    /*
        1.把接口分为外部和内部接口，所有空值判断放在外部接口完成；而内部接口传入的变量由外部接口保证不为空，从而减少空值判断。

        2.利用多态，把业务判断消除，各子类分别关注自己的实现，并实现子类的创建方法，避免用户了解过多的类(如果是第三方SDK,这样把子类就暴露给第三方了)。


        3.工厂模式,把分支状态信息预先缓存在Map里，直接get获取具体值，消除分支。

     */

    //方法一的外部接口(利用外部接口判断空,内部接口处理业务)
    public void method1(String a, String b, Business business) {

        if (a==null||b==null||business==null)
            throw new RuntimeException("空指针");

        innerMethod1(a,b,business);

    }

    //方法一的内部接口
    private void innerMethod1(String a,String b,Business business){
        //方法二,利用多态实现自己业务
        business.doBusiness(a, b);
    }


    //方法三
    public void method3(){

    }





}
