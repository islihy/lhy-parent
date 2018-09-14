package org.lhy.design.proxy.test.test02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/5 上午1:53
 */
public class DynamicProxyHandler implements InvocationHandler{

    private Object object;

    public DynamicProxyHandler(final Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前准备");
        Object result = method.invoke(object, args);
        System.out.println("代理后准备");
        return result;
    }
}
