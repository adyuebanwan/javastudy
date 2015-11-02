package org.hedy.javastudy.j2se.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2015/10/27.
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet();
        set.add(2);
        set.add(1);
        set.add(3);
        for(Integer i:set){
            System.out.println(i);
        }
    }
}
