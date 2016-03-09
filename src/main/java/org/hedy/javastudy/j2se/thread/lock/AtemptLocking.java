package org.hedy.javastudy.j2se.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by www.magicalcoder.com on 2015/8/7.
 * 799374340@qq.com
 *
 如果我们把每个线程理解成 一个个门，门都需要上锁，
 在没有ReentrantLock之前，我们上锁，可能统一用sycnchronized(钥匙),大家都在竞争锁钥匙，钥匙只有一把，谁先拥有谁就先开门进去，门打不开的就一直卡死等待，浪费时间，还不能干其他事情，就消耗在这里了

 有了ReEntrantLock，英文解释可重用锁， 就不需要钥匙了，我们可以灵活的为一组门（thread）配置一把特殊的锁，为另一组门配置另外一把锁，多灵活啊，这把锁仍然拥有synchronized的功能，
 1 如果用tryLock（非阻塞），此次获取不到锁，那你也不会等待，可以在门口玩会手机，或者去超时买菜，一会再来trylock一次 这个方法更灵活
 2如果用lock（阻塞）,那就跟synchronized一样的，获取了锁，就开门了，同一时刻 其他的门就死等，不能干其他事情

 另外提醒：trylock lock成功了 都要释放锁各一次，否则就死锁了哦
 */
class AtemptLocking {

    public static void main(String[] args) {
        //这个锁好啊 synchronized 是整个cpu的一把锁
        //而reentrantlock 是为每个子线程都可以配置一把锁 相当于有很多锁 更细粒度 更灵活
        ReentrantLock lock = new ReentrantLock();//第一把锁
        ReentrantLock lock1 = new ReentrantLock();//第二把锁
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Worker(lock,10));
        executorService.execute(new Worker(lock,1));
        executorService.execute(new Worker2(lock1,10));
        executorService.execute(new Worker2(lock1,1));
        executorService.shutdown();
    }



}
