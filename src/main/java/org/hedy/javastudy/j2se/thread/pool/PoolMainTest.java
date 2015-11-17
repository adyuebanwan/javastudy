package org.hedy.javastudy.j2se.thread.pool;

import java.util.concurrent.*;

/**
 * Created by hzhedongyu on 2015/10/30.
 */
public class PoolMainTest {
    public static void main(String[] args) {
        //阻塞队列用来放置请求来的线程 超过了maximumPoolSize 不至于抛出异常 先放queue里面
//        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, queue,
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    System.out.println("异常");
                    }
        });
        //来着客户端的请求线程
        for(int i=0;i<10;i++){
            pool.submit(new ThreadPoolRunnable("线程"+i));
            System.out.println("当前队列大小：" + queue.size());
        }
        pool.shutdown();

    }
}
