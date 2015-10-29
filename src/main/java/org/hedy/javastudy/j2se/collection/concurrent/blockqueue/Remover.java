package org.hedy.javastudy.j2se.collection.concurrent.blockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by hzhedongyu on 2015/10/29.
 */
public class Remover<T> implements Runnable {
    private BlockingQueue<T> blockingQueue;

    public Remover(BlockingQueue<T> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true){
                T v = blockingQueue.take();
                System.out.println(Thread.currentThread().getName()+"-remove-"+v);
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
