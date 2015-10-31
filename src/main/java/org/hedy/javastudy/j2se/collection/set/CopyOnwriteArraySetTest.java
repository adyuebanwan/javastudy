package org.hedy.javastudy.j2se.collection.set;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2015/10/29.
 */
public class CopyOnwriteArraySetTest {
    public static void main(String[] args) {
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<String>();
        set.add("1");
        set.add("1");
        set.add("1");

        System.out.println(set.size());

        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        list.add(1);
        list.add(1);
        System.out.println(list.size());
      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                set.remove(1);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();*/
    }
}
