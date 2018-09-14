package org.lhy.design.decorator.test;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/4 下午12:08
 */
public class ConcreteDecoratorB extends Decorator {
    private void BFunction() {
        System.out.println("组合装饰B独有方法");
    }
    @Override
    public void operation() {
        /**
         *运行原Component的operation方法
         */
        super.operation();
        /**
         * 执行本类的功能，相当于对原Component方法进行了装饰
         */
        BFunction();
    }

}
