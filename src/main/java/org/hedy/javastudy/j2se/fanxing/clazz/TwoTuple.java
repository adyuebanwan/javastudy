package org.hedy.javastudy.j2se.fanxing.clazz;

/**
 * Created by www.magicalcoder.com on 2015/9/2.
 * 799374340@qq.com
 */
public class TwoTuple<T,S> {
    private T a;
    private S b;

    public TwoTuple(T t,S s){
        this.a = t;
        this.b = s;
    }

    public T getA(){
        return a;
    }
    public S getB(){
        return b;
    }
}
