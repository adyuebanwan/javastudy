package org.hedy.javastudy.j2se.thread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by www.magicalcoder.com on 2015/8/6.
 * 799374340@qq.com
 */
class CyclicMain {

    public static void main(String[] args) {
        int num = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);//第二个参数 是线程 就是所有子线程完成任务后会开始执行他 这里就不演示了
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<num;i++){
            executorService.execute(new Worker(cyclicBarrier));
        }
        executorService.shutdown();
        //主线程没有阻塞 而是阻塞到了子线程
        System.out.println("主线程正在做其他工作");
    }
}
