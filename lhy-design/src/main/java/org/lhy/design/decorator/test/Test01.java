package org.lhy.design.decorator.test;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/4 下午12:12
 */
public class Test01 {
    public static void main(String[] args) {

        ConcreteComponent cc=new ConcreteComponent();

        ConcreteDecoratorA d1=new ConcreteDecoratorA();

        ConcreteDecoratorB d2 = new ConcreteDecoratorB();

        d1.setComponent(cc);

        d2.setComponent(d1);

        d2.operation();

    }
}