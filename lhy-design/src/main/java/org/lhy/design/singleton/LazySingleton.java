package org.lhy.design.singleton;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/5 上午3:09
 */
public class LazySingleton {
    private LazySingleton(){}

    private static LazySingleton lazySingleton = null;

    public static synchronized LazySingleton getInstance(){
        if (lazySingleton==null){
            return lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
