package org.hedy.javastudy.j2se.fanxing.allmatchchar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hedongyu on 2015/9/2.
 * 799374340@qq.com
 */
public class FruitMain {
    public static void main(String[] args) {
        List<? extends Fruit> list = new ArrayList<Fruit>();
        List<? extends Fruit> appleList = new ArrayList<Apple>();
        List<?> l = new ArrayList<Apple>();
    }
}
