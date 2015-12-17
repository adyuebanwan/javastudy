package org.hedy.javastudy.j2se.thread.threadlocal;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hedongyu on 2015/8/7.
 * 799374340@qq.com
 * 线程本地化存储 多个线程调用threadlocal 其实他会为每个线程创建一份单独的空间 这样多个线程互不干涉
 * ThreadLocal是解决线程安全问题一个很好的思路，它通过为每个线程提供一个独立的变量副本解决了变量并发访问的冲突问题。
 * 在很多情况下，ThreadLocal比直接使用synchronized同步机制解决线程安全问题更简单，更方便，且结果程序拥有更高的并发性。
 *
 */
class ThreadLocalMain {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected synchronized Integer initialValue() {//初始化数值
            return new Random().nextInt(100);
        }
    };

    public static void increment(){
        threadLocal.set(threadLocal.get()+1);
    }
    public static int get(){
        return threadLocal.get();
    }
    //一旦remove掉后 可能就为空 那么就会重新取 initalValue来设置值
    public static void remove(){
        threadLocal.remove();
    }
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            executorService.execute(new HttpRequest());
        }
        executorService.shutdown();

    }

}
