package org.hedy.javastudy.j2se.collection.concurrent.blockqueue.delay;

import java.util.concurrent.DelayQueue;

/**
 * Created by Administrator on 2015/11/17.
 */
public class DelayTest {
    public static void main(String[] args) {
        DelayQueue<DelayItem> delayQueue = new DelayQueue<DelayItem>();
        delayQueue.add(new DelayItem("1",1));
        delayQueue.add(new DelayItem("2",3));
        delayQueue.add(new DelayItem("3",24));


        Thread thread = new Thread(new DelayRunnable(delayQueue));
        thread.start();


    }
}
