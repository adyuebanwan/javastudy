package org.hedy.javastudy.j2se.fanxing.side;

/**
 * Created by www.magicalcoder.com on 2015/9/2.
 * 799374340@qq.com
 * 有了边界继承 可以预先知道T的类型和方法
 * 类继承extends
 * 接口继承 & 可以多继承
 */
public class ProductFactory<T extends  Product & ProductTwo > {
    public void desc(T t){
        t.info();
        t.did();
    }
}
