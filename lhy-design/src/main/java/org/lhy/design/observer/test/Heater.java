package org.lhy.design.observer.test;

/**
 * 热水器
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/2 下午6:08
 */
public class Heater extends Subject {
    private int temperature;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void boilWater(){
        for(int i=95;i<105;i++){
            temperature = i;
            /**
             * 设置新的温度
             */
            this.setTemperature(temperature);
            /**
             * 通知所有注册的观察者
             */
            this.notifyAllObservers(Integer.toString(temperature));
        }
    }
}
