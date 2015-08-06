package org.hedy.javastudy.j2se.thread.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by hedongyu on 2015/8/6.
 * 799374340@qq.com
 */
class Worker implements Runnable{
    private CyclicBarrier cyclicBarrier;

    public Worker(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(3));
            System.out.println(Thread.currentThread().getName()+"完成工作将要等待");
            cyclicBarrier.await();//关键点 暂时阻塞这里 你完成了任务你就等待吧 等所有人都到达 了等待点 那就结束等待
            System.out.println(Thread.currentThread().getName()+"完成等待");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
