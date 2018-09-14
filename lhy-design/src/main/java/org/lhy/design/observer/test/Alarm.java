package org.lhy.design.observer.test;

/**
 * 警报器
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/2 下午6:09
 */
public class Alarm implements Observer {


    @Override
    public void update(String state) {
        Boolean flag = Boolean.parseBoolean(state);
        if(flag){
            System.out.println("报警器响了，水温超过100度了。");
        }
    }

}