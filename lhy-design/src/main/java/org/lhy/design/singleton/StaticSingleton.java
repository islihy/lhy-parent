package org.lhy.design.singleton;


/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/5 上午3:12
 */
public class StaticSingleton {

    private StaticSingleton(){}

    private static class SingletonHandle{
        private static StaticSingleton staticSingleton = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return SingletonHandle.staticSingleton;
    }
}
