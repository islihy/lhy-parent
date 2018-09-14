package org.lhy.design.decorator.test;

/**
 * 继承父类，重写和实现父类的目标方法。
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/4 下午12:06
 */
public class ConcreteDecoratorA extends Decorator {
    private void AFunction() {
        System.out.println("组合装饰A独有方法");
    }
    @Override
    public void operation() {
        /**
         * 运行原Component的operation方法
         */
        super.operation();
        /**
         * 执行本类的功能，相当于对原Component方法进行了装饰
         */
        AFunction();
    }
}
