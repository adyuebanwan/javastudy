package org.hedy.javastudy.j2se.thread.volatile1;

/**
 * Created by Administrator on 2015/11/21.
 */
class Reader implements Runnable{
    private Item item;

    public Reader(Item item) {
        this.item = item;
    }

    @Override
    public void run() {
       /* while (item.isFlag())
        System.out.println(Thread.currentThread().getName()+item.isFlag());*/

        while (true){
            System.out.println(item.getCount());
        }
    }
}
