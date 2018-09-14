package org.lhy.design.observer.test.test;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/2 下午6:40
 */
public class Test {
    public static void main(String[] args) {
        Boss boss = new Boss();
        Server01 server01 = new Server01();
        Server02 server02 = new Server02();

        boss.addObserver(server01);
        boss.addObserver(server02);

        boss.order();
    }
}
