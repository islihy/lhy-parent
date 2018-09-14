package org.lhy.design.proxy.test.test01;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/5 上午1:44
 */
public class Test {

    public static void main(String[] args) {
        BuyHouse buyHouse01 = new BuyHouseImpl();
        buyHouse01.buyHosue();

        BuyHouse buyHouse02 = new BuyHouseProxy((BuyHouseImpl)buyHouse01);
        buyHouse02.buyHosue();

    }
}
