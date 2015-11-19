package org.hedy.javastudy.j2se.collection.concurrent.blockqueue.delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2015/11/17.
 */
public class DelayItem implements Delayed{

    private String name;
    private long expireTime;

    public DelayItem(String name, long expireTime) {
        this.name = name;
        this.expireTime = TimeUnit.NANOSECONDS.convert(expireTime, TimeUnit.SECONDS) + System.nanoTime();
    }

    @Override
    public long getDelay(TimeUnit unit) {//还有多长时间就要出队列了
        return unit.convert(expireTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {//保证FIFO 元素在延迟队列中的顺序 要把最先过期的排在最前面 否则就达不到延迟队列的作用了
        DelayItem that = (DelayItem)o;
        return expireTime > that.expireTime?1:(expireTime < that.expireTime ? -1 : 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
