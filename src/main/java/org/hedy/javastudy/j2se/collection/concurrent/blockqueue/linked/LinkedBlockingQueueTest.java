package org.hedy.javastudy.j2se.collection.concurrent.blockqueue.linked;

import org.hedy.javastudy.j2se.collection.concurrent.blockqueue.thread.Adder;
import org.hedy.javastudy.j2se.collection.concurrent.blockqueue.thread.Remover;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by hzhedongyu on 2015/10/30.
 * 大小不固定
 * 链状结构
 */
public class LinkedBlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>();
        new Thread(new Adder<String>(blockingQueue)).start();
        new Thread(new Remover<String>(blockingQueue)).start();
    }
}
