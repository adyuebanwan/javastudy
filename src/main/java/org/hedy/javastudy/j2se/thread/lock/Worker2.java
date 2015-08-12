package org.hedy.javastudy.j2se.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hedongyu on 2015/8/7.
 * 799374340@qq.com
 */
class Worker2 implements Runnable{
    private ReentrantLock lock = new ReentrantLock();
    private long timeOut;
    public Worker2(ReentrantLock lock, long timeOut) {
        this.lock = lock;
        this.timeOut = timeOut;
    }

    @Override
    public void run() {
//        lockWorking();
        lock();
    }

    /**
     * tryLock 需要unlock  tryLock不阻塞 如果你不想等待 那就继续下去吧 做你自己喜欢的事情
     * lock 需要unlock 否则就不会退出锁 lock阻塞
     */
    public void lockWorking(){
        String name = Thread.currentThread().getName()+" ";
        lock.lock();
        boolean locked = lock.tryLock();//这个并不阻塞
        try{
            System.out.println(name+"get lock "+locked);
            if(locked){
                System.out.println(name+"working");
                TimeUnit.SECONDS.sleep(10);
                System.out.println(name+"finish work");
            }else {
                System.out.println(name+"go out!");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(locked){
                System.out.println(name+"release lock"+locked);
                lock.unlock();
                lock.unlock();
            }
        }


    }

    /**
     *
     * @param timeOut
     */
    public void lockWorking(long timeOut){
        boolean locked = false;
        try{
            locked = lock.tryLock(timeOut, TimeUnit.SECONDS);
            System.out.println("working"+locked);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(locked){
                lock.unlock();
            }
        }
    }

    public void  lock(){
        synchronized (Worker2.class){
            String name = Thread.currentThread().getName()+" ";
            try {
                System.out.println(name+"lock");
                TimeUnit.SECONDS.sleep(10);
                System.out.println(name+"release lock");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
