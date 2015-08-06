package org.hedy.javastudy.j2se.thread.future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by hedongyu on 2015/8/6.
 * 799374340@qq.com
 */
class Worker implements Callable<String> {
    @Override
    public String call() throws Exception {
        long s = new Random().nextInt(5);
        System.out.println(s);
        TimeUnit.SECONDS.sleep(s);
        String name = Thread.currentThread().getName();
        System.out.println(name +"有返回");
        return name;
    }
}
