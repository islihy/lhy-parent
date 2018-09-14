package org.lhy.design.observer.test;

/**
 * 观察者接口
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/2 下午6:07
 */

public interface Observer {
    /**
     * 更新接口
     * @param state 更新的状态
     */
    void update(String state);
}

