package org.lhy.design.builder.test;

/**
 * 作者：六尺帐篷
 链接：https://www.jianshu.com/p/f4248525e2d1
 來源：简书
 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/7/31 下午3:52
 */
public class Computer {
    public String master;
    public String screen;
    public String keyboard;
    public String mouse;
    public String audio;
    public void setMaster(String master) {
        this.master = master;
    }
    public void setScreen(String screen) {
        this.screen = screen;
    }
    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }
    public void setMouse(String mouse) {
        this.mouse = mouse;
    }
    public void setAudio(String audio) {
        this.audio = audio;
    }
}
