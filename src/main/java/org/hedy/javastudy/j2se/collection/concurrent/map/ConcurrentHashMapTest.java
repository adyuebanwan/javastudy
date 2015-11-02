package org.hedy.javastudy.j2se.collection.concurrent.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hzhedongyu on 2015/10/30.
 */
public class ConcurrentHashMapTest {
    private static ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<String, String>();
    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new Runnable() {
            @Override
            public void run() {
                concurrentHashMap.put("1","1");
            }
        });
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(concurrentHashMap.get("1"));
            }
        });

        service.shutdown();
    }
}
