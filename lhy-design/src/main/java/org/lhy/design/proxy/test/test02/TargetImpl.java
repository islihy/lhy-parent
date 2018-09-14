package org.lhy.design.proxy.test.test02;

import org.apache.tools.tar.TarEntry;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/5 上午2:29
 */
public class TargetImpl implements Target{
    @Override
    public void demo01() {
        System.out.println("demo01");
    }

    @Override
    public int demo02(int a) {
        System.out.println("demo02");
        return a;
    }
}
