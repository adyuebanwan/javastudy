package org.hedy.javastudy.j2se.thread.volatile1;

/**
 * Created by Administrator on 2015/11/21.
 */
public class VolotileTest {
    public static void main(String[] args) {
        Item item = new Item();
        for(int i=0;i<10000;i++){
            new Thread(new Writer(item)).start();
        }
        new Thread(new Reader(item)).start();

    }
}
