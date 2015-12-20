package org.hedy.javastudy.j2se.thread.volatile1;

/**
 * Created by Administrator on 2015/11/21.
 */
class Writer implements Runnable{
    private Item item;

    public Writer(Item item) {
        this.item = item;
    }
    @Override
    public void run() {
        //item.setFlag(false);
        item.incr();
    }
}
