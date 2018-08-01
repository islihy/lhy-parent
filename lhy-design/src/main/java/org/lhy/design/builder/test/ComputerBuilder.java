package org.lhy.design.builder.test;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/7/31 下午3:53
 */
public abstract class ComputerBuilder {
    protected Computer computer;

    public Computer getComputer() {
        return computer;
    }

    public void buildComputer() {
        computer = new Computer();
        System.out.println("生成了一台电脑！！！");
    }

    public abstract void buildMaster();
    public abstract void buildScreen();
    public abstract void buildKeyboard();
    public abstract void buildMouse();
    public abstract void buildAudio();
}
