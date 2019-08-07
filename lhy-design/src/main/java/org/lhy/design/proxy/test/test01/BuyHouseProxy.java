package org.lhy.design.proxy.test.test01;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/5 上午1:41
 */

/**
 * proxy代理对象：需要和目标类实现同一接口
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

        System.out.println("日志记录：在目标方法执行之前");
        buyHouse.buyHosue();
        System.out.println("日志记录：在目标方法执行之后");
    }
}
