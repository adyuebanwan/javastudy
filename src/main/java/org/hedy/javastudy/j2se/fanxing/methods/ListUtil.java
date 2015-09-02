package org.hedy.javastudy.j2se.fanxing.methods;

import java.util.List;

/**
 * Created by hedongyu on 2015/9/2.
 * 799374340@qq.com
 * 泛型方法
 */
public class ListUtil {
    public static <T> boolean isBlank(List<T> list){
        return list==null || list.size()<=0;
    }
}
