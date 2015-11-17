package org.hedy.javastudy.j2se.collection.concurrent.blockqueue.linked;

import org.hedy.javastudy.j2se.collection.concurrent.blockqueue.array.Adder;
import org.hedy.javastudy.j2se.collection.concurrent.blockqueue.array.Remover;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Administrator on 2015/11/17.
 */
public class LinkedBlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingDeque<String>();
        new Thread(new Adder<String>(queue)).start();
        new Thread(new Remover<String>(queue)).start();

    }
}
