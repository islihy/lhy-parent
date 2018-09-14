package org.lhy.design.proxy.test.test01;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/5 上午1:41
 */
public class BuyHouseProxy implements BuyHouse{

    private BuyHouseImpl buyHouse;

    public BuyHouseProxy(BuyHouseImpl buyHouse01) {
        this.buyHouse = buyHouse01;
    }

    public BuyHouseImpl setBuyHouse(BuyHouseImpl buyHouseImpl) {
        return this.buyHouse = buyHouseImpl;
    }

    @Override
    public void buyHosue() {

        System.out.println("买房前准备");
        buyHouse.buyHosue();
        System.out.println("买房后装修");
    }
}
