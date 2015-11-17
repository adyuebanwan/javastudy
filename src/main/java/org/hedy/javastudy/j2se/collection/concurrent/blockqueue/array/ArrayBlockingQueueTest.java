package org.hedy.javastudy.j2se.collection.concurrent.blockqueue.array;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by hzhedongyu on 2015/10/29.
 * 一旦设定了数组大小 就不能改变了
 * ArrayBlockingQueue 内部以 FIFO(先进先出)的顺序对元素进行存储。队列中的头元素在所有元素之中是放入时间最久的那个，而尾元素则是最短的那个。
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
        new Thread(new Remover<String>(queue)).start();
        new Thread(new Remover<String>(queue)).start();
        new Thread(new Remover<String>(queue)).start();
    }
}
