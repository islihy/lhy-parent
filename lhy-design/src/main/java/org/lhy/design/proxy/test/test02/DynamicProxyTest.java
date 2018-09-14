package org.lhy.design.proxy.test.test02;

import org.lhy.design.proxy.test.test01.BuyHouse;
import org.lhy.design.proxy.test.test01.BuyHouseImpl;

import java.lang.reflect.Proxy;

/**
 * Proxy.newProxyInstance()方法接受三个参数：
 * ClassLoader loader:指定当前目标对象使用的类加载器,获取加载器的方法是固定的
 * Class<?>[] interfaces:指定目标对象实现的接口的类型,使用泛型方式确认类型
 * InvocationHandler:指定动态处理器，执行目标对象的方法时,会触发事件处理器的方法
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/5 上午1:56
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        Target t = new TargetImpl();
        Target target = (Target) Proxy.newProxyInstance(Target.class.getClassLoader(), new Class[]{Target.class}, new DynamicProxyHandler(t));
        target.demo01();
        int a = target.demo02(2);
        System.out.println(a);
    }
}
