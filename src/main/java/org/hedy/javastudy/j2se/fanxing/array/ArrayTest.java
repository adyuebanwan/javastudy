package org.hedy.javastudy.j2se.fanxing.array;

/**
 * Created by hedongyu on 2015/9/2.
 * 799374340@qq.com
 */
public class ArrayTest<T> {
    private Class<T> clazz;//可以利用这个来判断造型的类型
    public void isBlank(T... obj){
        clazz.isInstance(String.class);
    }

    public static void main(String[] args) {

    }
}
