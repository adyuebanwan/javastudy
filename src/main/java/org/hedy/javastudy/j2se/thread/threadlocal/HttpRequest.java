package org.hedy.javastudy.j2se.thread.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * Created by hedongyu on 2015/8/7.
 * 799374340@qq.com
 */
class HttpRequest implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+" "+ThreadLocalMain.get());
            ThreadLocalMain.increment();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
        }
        //将当前线程局部变量的值删除，目的是为了减少内存的占用，该方法是JDK 5.0新增的方法。需要指出的是，当线程结束后，对应该线程的局部变量将自动被垃圾回收，所以显式调用该方法清除线程的局部变量并不是必须的操作，但它可以加快内存回收的速度。
        ThreadLocalMain.remove();

    }
}
