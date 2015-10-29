package org.hedy.javastudy.j2se.collection.concurrent.blockqueue.arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by hzhedongyu on 2015/10/29.
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) {
        //最常用的先进先出 put take 都是带锁的方法
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);
        new Thread(new Adder<String>(queue)).start();
        new Thread(new Adder<String>(queue)).start();
        new Thread(new Adder<String>(queue)).start();
        new Thread(new Adder<String>(queue)).start();
        new Thread(new Adder<String>(queue)).start();
        new Thread(new Adder<String>(queue)).start();
        new Thread(new Adder<String>(queue)).start();
//        new Thread(new Remover<String>(queue)).start();
//        new Thread(new Remover<String>(queue)).start();
//        new Thread(new Remover<String>(queue)).start();
    }
}
