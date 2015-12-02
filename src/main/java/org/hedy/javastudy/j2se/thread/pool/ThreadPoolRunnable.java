package org.hedy.javastudy.j2se.thread.pool;

import java.util.concurrent.TimeUnit;

/**
 * Created by hzhedongyu on 2015/10/30.
 */
public class ThreadPoolRunnable implements Runnable {
    private String name;

    public ThreadPoolRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (this){
            try {
                System.out.println("干活的"+name);
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
