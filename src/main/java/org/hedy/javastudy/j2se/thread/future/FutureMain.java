package org.hedy.javastudy.j2se.thread.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by www.magicalcoder.com on 2015/8/6.
 * 799374340@qq.com
 */
class FutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int num = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> r1 = executorService.submit(new Worker(4));
        Future<String> r2 = executorService.submit(new Worker(2));
//        Future<String> r3 = executorService.submit(new Worker(3));
//        Future<String> r4 = executorService.submit(new Worker(4));
//        Future<String> r5 = executorService.submit(new Worker(5));
        executorService.shutdown();
        //目前还没有阻塞
        String s1 = r1.get();//到这里就开始阻塞了
        System.out.println(s1);

        String s2 = r2.get();//下面一个个阻塞 上面的不返回下面的就一直等待
//        String s3 = r3.get();//到这里就开始阻塞了
//        String s4 = r4.get();//到这里就开始阻塞了
//        String s5 = r5.get();//到这里就开始阻塞了

        System.out.println(s1+s2);
    }
}
