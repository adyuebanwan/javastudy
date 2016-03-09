package org.hedy.javastudy.j2se.collection.concurrent.concurrentqueue;

import java.util.concurrent.*;

/**
 * Created by hzwww.magicalcoder.com on 2015/11/23.
 * 只有add poll offer peek 这样单独调用 才是线程安全的 但是多个一起调用 可就不安全了
 * 例如 !queue.isEmpty() System.out.println(queue.poll()); 这两个方法中间的时刻就可能被竞争
 *在使用ConcurrentLinkedQueue时要注意，如果直接使用它提供的函数，比如add或者poll方法，这样我们自己不需要做任何同步。
 但如果是非原子操作，比如：
 Java代码  收藏代码
 if(!queue.isEmpty()) {
 queue.poll(obj);
 }

 我们很难保证，在调用了isEmpty()之后，poll()之前，这个queue没有被其他线程修改。所以对于这种情况，我们还是需要自己同步：
 Java代码  收藏代码
 synchronized(queue) {
 if(!queue.isEmpty()) {
 queue.poll(obj);
 }
 }

 注：这种需要进行自己同步的情况要视情况而定，不是任何情况下都需要这样做。
 另外还说一下，ConcurrentLinkedQueue的size()是要遍历一遍集合的，所以尽量要避免用size而改用isEmpty()，以免性能过慢。

 总结：CAS操作 比 lock操作更轻便 乐观锁
 */
public class ConcurrentLinkedQueueTest {
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<10;i++)
        test2();
//        test1();
    }
    private static void test1() throws InterruptedException {
        long a = System.currentTimeMillis();
        final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
        final int size = 10000;
        final CountDownLatch latch = new CountDownLatch(size);
        for(int i=0;i<size;i++){
            queue.add(i + "");
        }
        for(int i=0;i<size;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized ("1"){//这个锁才可以保障 下面安全执行
                        while (!queue.isEmpty()){
                            //上下可能不安全啊
                            queue.poll();//这里可不阻塞
                        }
                        latch.countDown();
                    }
                }
            });
            thread.start();
        }
        latch.await();
        System.out.println(System.currentTimeMillis() - a );
    }
    private static void test2() throws InterruptedException {
        long a = System.currentTimeMillis();
        final BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
        final int size = 10000;
        final CountDownLatch latch = new CountDownLatch(size);
        for(int i=0;i<size;i++){
            queue.put(i + "");
        }
        for(int i=0;i<size;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        queue.take();//这里可是会阻塞的
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    latch.countDown();
                }
            });
            thread.start();
        }
        latch.await();
        System.out.println(System.currentTimeMillis() - a);
    }
}
