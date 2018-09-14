package org.lhy.design.observer.test;

/**
 * 显示器，既是观察者又是被观察者
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/2 下午6:08
 */
public class Display extends Subject implements Observer {

    /**
     * 表示水是否烧开了
     */
    private boolean isBoiled = false;
    /**
     * 定义显示器的温度
     */
    private int displayTemperature;

    public void setBoiled(boolean isBoiled) {
        this.isBoiled = isBoiled;
    }

    @Override
    public void update(String state) {
        displayTemperature = Integer.parseInt(state);
        System.out.println("当前显示器显示的温度是："+displayTemperature);
        this.displayTemperature(displayTemperature);

    }

    private void displayTemperature(int temperature){
        if(temperature>100){
            this.setBoiled(true);
            this.notifyAllObservers(Boolean.toString(isBoiled));
        }
    }
}
