package org.hedy.javastudy.j2se.fanxing.clazz;

/**
 * Created by www.magicalcoder.com on 2015/9/2.
 * 799374340@qq.com
 */
public class AppleCompanyFactory<T>{

    private T instance;

    public void setInstance(T t){
        this.instance = t;
    }

    public T getProduct(){
        return instance;
    }
}
