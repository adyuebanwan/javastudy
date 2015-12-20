package org.hedy.javastudy.j2se.thread.volatile1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2015/11/21.
 */
class Item {
    private boolean flag = true;
    private volatile int count=0;//volatile 并没有什么用 还是靠lock
    private ReentrantLock lock = new ReentrantLock();
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void incr(){
        lock.lock();
        count++;
        lock.unlock();
    }
}
