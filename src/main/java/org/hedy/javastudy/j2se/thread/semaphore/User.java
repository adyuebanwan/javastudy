package org.hedy.javastudy.j2se.thread.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by hedongyu on 2015/8/6.
 * 799374340@qq.com
 */
class User implements Runnable {
    private Semaphore semaphore;

    public User(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        int canUseCount = semaphore.availablePermits();

        if(canUseCount>0){
            System.out.println(name+"还有座位去获取下看看");
        }else {
            System.out.println(name+"请您排队");
        }
        try {
            semaphore.acquire();//如果没有许可 阻塞当前线程
            System.out.println(name+"恭喜您获得座位");
            TimeUnit.SECONDS.sleep(3);
            semaphore.release();//返回1个许可
            System.out.println(name+"聊天结束 释放座位88888888888888");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
