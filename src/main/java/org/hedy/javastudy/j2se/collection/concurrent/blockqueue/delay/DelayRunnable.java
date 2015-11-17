package org.hedy.javastudy.j2se.collection.concurrent.blockqueue.delay;

import java.util.concurrent.DelayQueue;

/**
 * Created by Administrator on 2015/11/17.
 */
public class DelayRunnable implements Runnable {
    private DelayQueue<Item> delayQueue;

    public DelayRunnable(DelayQueue<Item> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        try {
            while (true){
                Item item = delayQueue.take();
                System.out.println(item.getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
