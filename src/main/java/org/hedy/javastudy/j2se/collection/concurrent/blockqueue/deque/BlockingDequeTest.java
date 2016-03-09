package org.hedy.javastudy.j2se.collection.concurrent.blockqueue.deque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by hzwww.magicalcoder.com on 2015/11/19.
 */
public class BlockingDequeTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> deque = new LinkedBlockingDeque<String>();
        deque.addFirst("1");
        deque.addLast("2");
        System.out.println(deque.takeFirst());
        System.out.println(deque.takeLast());



    }
}
