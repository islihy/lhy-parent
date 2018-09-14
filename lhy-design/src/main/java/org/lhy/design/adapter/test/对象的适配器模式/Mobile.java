package org.lhy.design.adapter.test.对象的适配器模式;

/**
 * 介绍：Client类：手机 .需要5V电压
 * 作者：zhangxutong
 * 邮箱：zhangxutong@imcoming.com
 * 时间： 2016/10/18.
 */
public class Mobile {
    /**
     * 充电方法
     *
     * @param voltage5
     */
    public void charging(Voltage5 voltage5) {
        if (voltage5.output5V() == 5) {
            System.out.println("电压刚刚好5V，开始充电");
        } else if (voltage5.output5V() > 5) {
            System.out.println("电压超过5V，都闪开 我要变成note7了");
        }
    }
    public static void main(String[] args) {
        System.out.println("\n===============对象适配器==============");
        VoltageAdapter voltageAdapter2 = new VoltageAdapter(new Voltage220());
        Mobile mobile2 = new Mobile();
        mobile2.charging(voltageAdapter2);
    }
}
