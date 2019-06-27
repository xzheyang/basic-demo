package com.hy.basic.java.multithreading.normal_use.hy_concurrent;

import java.util.concurrent.*;

/**
 * @user yang.he
 * @date 2019/6/25
 * @introduce
 **/
public class FutureEg {

    static class IFuture implements Future<Integer>{

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            return false;
        }

        @Override
        public boolean isCancelled() {
            return false;
        }

        @Override
        public boolean isDone() {
            return false;
        }

        @Override
        public Integer get() throws InterruptedException, ExecutionException {
            Integer result = 1;
            for (int i=1;i<1000;i++){
                result = result+i;
            }
            return result;
        }

        @Override
        public Integer get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return null;
        }
    }

    static class IFutureTask extends FutureTask<Integer>{
        public IFutureTask(Callable<Integer> callable) {
            super(callable);
        }

        public IFutureTask(Runnable runnable, Integer result) {
            super(runnable, result);
        }
    }

}
