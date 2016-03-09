package org.hedy.javastudy.j2se.thread.pool;

import java.util.concurrent.*;

/**
 * Created by hzwww.magicalcoder.com on 2015/10/30.
 * 线程池最大能接受的线程数 maxinumPoolSize+queue.size
 */
public class PoolMainTest {
    public static void main(String[] args) {
        //阻塞队列用来放置请求来的线程 超过了maximumPoolSize 不至于抛出异常 先放queue里面
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(2);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 20, 10, TimeUnit.SECONDS, queue,
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("被拒绝放入");
                    }
        });
        //来着客户端的请求线程
        for(int i=0;i<10;i++){
            System.out.println("准备放入线程"+i);
            pool.execute(new ThreadPoolRunnable("线程" + i));
        }
        pool.shutdown();

    }
}
