package com.hy.basic.java.grammar.java8features;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

/**
 * @user hy
 * @date sometime
 * @introduce            java8提供的流处理,支持并发
 *
 **/
public class JavaStream {

    @Test
    public void create() {

        //普通流
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        //并行流
        List<String> parallelFiltered = strings.parallelStream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        /*
                并行流发现会有问题产生,似乎不适用于生产

                1.它主要是使用fork/join的线程池,每个cpu一个线程,这样导致线程共享和线程池分配不合理
                2.对应List数组类性能好(因为需要数据分解),Set一般,LinkedList极差
                3.同样不能对外部共享变量做写操作
                4.List等集合类是非线程安全,需要使用线程安全的CopyOnWriteArrayList等集合类,不然会出现多分发数据的情况,出现越界

         */

        final List<String> goodParallel = null;

        //新建fork线程池来执行程序
        ForkJoinPool forkJoinPool = new ForkJoinPool(3);
        forkJoinPool.submit(() -> {
            //现在暂时无法一次性全部导入到结果,需要foreach才行
            strings.parallelStream().map(string -> !string.isEmpty());
        });


    }

}
