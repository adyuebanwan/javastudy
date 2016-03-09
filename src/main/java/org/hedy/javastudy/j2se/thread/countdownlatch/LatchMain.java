package org.hedy.javastudy.j2se.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by www.magicalcoder.com on 2015/8/6.
 * 799374340@qq.com
 */
class LatchMain {
    public static void main(String[] args) throws InterruptedException {
        int num = 5;
        CountDownLatch latch = new CountDownLatch(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        for(int i=0;i<num;i++){
            executorService.execute(new Worker(latch));
        }
        executorService.shutdown();
        latch.await();//所有人在这个点都被阻塞 主线程也阻塞
        System.out.println("所有人已经完成任务 开始汇总");

    }
}
