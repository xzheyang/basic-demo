package com.hy.basic.java.specification;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @user hy
 * @date sometime
 * @introduce           空指针规范    多重空
 **/
public class NullPointSpec {


    public static void main(String[] args) {

//        这里子嵌套是空的,不会打印

//        normalSpec();
//        java8NormalSpec();
        invokeEasyJava8Spec();

    }


    //普通的判断空指针方法
    public static void normalSpec() {
        // 繁琐的代码
        Outer outer = new Outer();
        if(outer != null && outer.nested != null && outer.nested.inner != null){
            System.out.println(outer.nested.inner.foo);
        }
    }


    //java8的简单判断空指针方法
    public static void java8NormalSpec() {
        // 繁琐的代码
        Optional.of(new Outer())
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .ifPresent(System.out::println); // 如果不为空，最终输出 foo 的值

    }

    public static void invokeEasyJava8Spec() {

        Outer obj = new Outer();
        // 直接调用 resolve 方法，内部做空指针的处理
        resolve(() -> obj.getNested().getInner().getFoo())
                .ifPresent(System.out::println); // 如果不为空，最终输出 foo 的值

    }

    /**
     *      利用Supplier函数获得简单的java8空指针方法
     *
     * @param resolver
     * @param <T>
     * @return
     */
    public static <T> Optional<T> resolve(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        }
        catch (NullPointerException e) {
            // 可能会抛出空指针异常，直接返回一个空的 Optional 对象
            return Optional.empty();
        }
    }


}

// 最外层对象
class Outer {
    Nested nested;
    Nested getNested() {
        return nested;
    }
}
// 第二层对象
class Nested {
    Inner inner;
    Inner getInner() {
        return inner;
    }
}
// 最底层对象
class Inner {
    String foo;
    String getFoo() {
        return foo;
    }
}



