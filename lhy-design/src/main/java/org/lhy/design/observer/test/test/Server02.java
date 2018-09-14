package org.lhy.design.observer.test.test;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/2 下午6:35
 */
public class Server02 implements Observer{
    @Override
    public void update() {
        System.out.println("滚，我不干了");
    }
}
