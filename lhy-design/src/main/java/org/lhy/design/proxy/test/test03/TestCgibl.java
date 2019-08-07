package org.lhy.design.proxy.test.test03;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/5 上午2:18
 */
public class TestCgibl {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        BuyHouse buyHouse = (BuyHouse)cglibProxy.getProxy(BuyHouse.class);
        buyHouse.buyHosue();
    }
}
