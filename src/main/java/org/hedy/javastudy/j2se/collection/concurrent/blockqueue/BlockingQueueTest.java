package org.hedy.javastudy.j2se.collection.concurrent.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by hzhedongyu on 2015/10/29.
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
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
