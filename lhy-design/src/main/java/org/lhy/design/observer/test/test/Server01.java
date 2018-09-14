package org.lhy.design.observer.test.test;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/2 下午6:34
 */
public class Server01 implements Observer{
    @Override
    public void update() {
        System.out.println("知道了，老板");
    }
}
