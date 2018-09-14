package org.lhy.design.factory.test.stage03;


/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/3 下午3:13
 */

interface IA{
    void show();
}

interface IB{
    void show();
}

class IA1 implements IA{
    @Override
    public void show() {
        System.out.println("这是IA1");
    }
}

class IA2 implements IA{
    @Override
    public void show() {
        System.out.println("这是IA2");
    }
}

class IB1 implements IB{
    @Override
    public void show() {
        System.out.println("这是IB1");
    }
}


interface IFactory{
    void createIA();
    void createIB();
}

class IfactoryImpl implements IFactory{
    @Override
    public void createIA() {
        IA ia1 = new IA1();
        IA ia2 = new IA2();
        ia1.show();
        ia2.show();
    }

    @Override
    public void createIB(){
        new IB1().show();
    }
}


public class Client {

    public static void main(String[] args) {

        IFactory n = new IfactoryImpl();
        n.createIA();
        n.createIB();
    }
}
