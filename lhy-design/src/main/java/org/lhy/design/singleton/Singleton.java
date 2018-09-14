package org.lhy.design.singleton;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/5 上午3:03
 */
public class Singleton {
    private Singleton(){}

    private static Singleton singleton = new Singleton();

    public static Singleton getInstatnce(){
        return singleton;
    }
}
