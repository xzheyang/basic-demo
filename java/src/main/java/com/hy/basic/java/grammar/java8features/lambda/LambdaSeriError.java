package com.hy.basic.java.grammar.java8features.lambda;

/**
 *
 *  lambda序列化异常
 */
public class LambdaSeriError {


    /**
     * Spark中使用序列化的异常:
     *      lambda表达式在序列化的过程中，不同于Java泛型的运行时擦除机制，会对类型进行特化，序列化前后的lambda表达式是携带类型信息的。
     *
     *  破解之法:
     *      使用匿名函数即可
     *
     *  参考:
     *      https://zhuanlan.zhihu.com/p/37995638                               //个人理解:同一个method-ref可能会绑定到同一个serializable lambda,lambda内置序列化误操作了
     *      https://www.zhihu.com/question/51491241/answer/126232275            //(三种lambda序列化方式)个人理解:因为捕获method-reference把实例引用,而实例又没有序列化接口,在spark中就会出错
     */


}
