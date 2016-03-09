package org.hedy.javastudy.j2se.fanxing.itface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by www.magicalcoder.com on 2015/9/2.
 * 799374340@qq.com
 */
public class ServiceImpl<T> implements Service<T> {
    @Override
    public List<T> getList() {
        return new ArrayList<T>();
    }
}
