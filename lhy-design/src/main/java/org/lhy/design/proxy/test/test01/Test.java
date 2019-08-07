package org.lhy.design.proxy.test.test01;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/5 上午1:44
 */
public class Test {

    public static void main(String[] args) {

        /**
         * 原版
         */
        BuyHouse buyHouse01 = new BuyHouseImpl();
        buyHouse01.buyHosue();

        System.out.println("----------实现静态代理后----------");

        /**
         * 加上了日志处理
         */
        BuyHouse buyHouse02 = new BuyHouseProxy((BuyHouseImpl)buyHouse01);
        buyHouse02.buyHosue();
    }
}
