package org.lhy.design.observer.test;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/2 下午6:11
 */
public class Test {
    public static void main(String[] args) {
        Heater heater = new Heater();
        Display display = new Display();
        Alarm alarm = new Alarm();

        heater.registerObserver(display);
        display.registerObserver(alarm);
        heater.boilWater();
    }
}
