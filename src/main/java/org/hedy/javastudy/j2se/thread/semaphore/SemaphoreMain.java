package org.hedy.javastudy.j2se.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by hedongyu on 2015/8/6.
 * 799374340@qq.com
 */
class SemaphoreMain {
    public static void main(String[] args) {
        //人太多 资源有限 怎么办 一个个排队吧
        int num = 10;//人数5个
        Semaphore sit = new Semaphore(2);//座位就2个
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        for(int i=0;i<num;i++){
            executorService.execute(new User(sit));
        }
        executorService.shutdown();
        System.out.println("主线程");
    }
}
