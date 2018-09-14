package org.lhy.design.observer.test.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/2 下午6:36
 */
public class Boss{
    private List<Observer> oLists = new ArrayList<Observer>();

    public void order(){
        System.out.println("来人把这个干了啊");
        oLists.forEach(e -> e.update());
    }

    public void addObserver(Observer observer){
        oLists.add(observer);
    }
}
