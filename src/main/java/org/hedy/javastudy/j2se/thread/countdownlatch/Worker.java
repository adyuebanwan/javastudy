package org.hedy.javastudy.j2se.thread.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by www.magicalcoder.com on 2015/8/6.
 * 799374340@qq.com
 */
class Worker implements Runnable{
    private CountDownLatch latch;

    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(3));
            System.out.println(Thread.currentThread().getName()+"干完活了");
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
