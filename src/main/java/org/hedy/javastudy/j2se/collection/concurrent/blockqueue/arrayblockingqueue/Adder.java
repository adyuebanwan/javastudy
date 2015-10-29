package org.hedy.javastudy.j2se.collection.concurrent.blockqueue.arrayblockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by hzhedongyu on 2015/10/29.
 */
public class Adder<T> implements Runnable {
    private BlockingQueue<T> blockingQueue;

    public Adder(BlockingQueue<T> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            int i=0;
            while (true){
                i=i+1;
                //入队
                blockingQueue.put((T)(""+i));
                System.out.println(Thread.currentThread().getName() + "-add-" + i);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
