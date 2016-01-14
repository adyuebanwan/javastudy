package org.hedy.javastudy.j2se.thread.future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by hedongyu on 2015/8/6.
 * 799374340@qq.com
 */
class Worker implements Callable<String> {
    private int second;

    public Worker(int second) {
        this.second = second;
    }

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(second);
        String name = Thread.currentThread().getName();
        return name;
    }
}
