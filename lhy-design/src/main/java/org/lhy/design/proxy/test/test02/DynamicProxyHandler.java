package org.lhy.design.proxy.test.test02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现日志输出，继承 InvocationHandler ：动态处理器，执行目标对象的方法时,会触发事件处理器的方法
 */
public class DynamicProxyHandler implements InvocationHandler{

    private Object object;

    public DynamicProxyHandler(final Object object){
        this.object = object;
    }

    /**
     * 固定写法，实现细节由jdk封装
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("日志记录：在目标方法执行之前");
        Object result = method.invoke(object, args);
        System.out.println("日志记录：在目标方法执行之后");
        return result;
    }
}
