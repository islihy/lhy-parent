package org.lhy.design.proxy.test.test03;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/5 上午2:17
 */
import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class CglibProxy implements MethodInterceptor {
    /**
     * 通过Enhancer 创建代理对象
     */
    private Enhancer enhancer = new Enhancer();

    /**
     * 通过Class对象获取代理对象
     */
    public Object getProxy(Class c){
        //设置创建子类的类
        enhancer.setSuperclass(c);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method m, Object[] args, MethodProxy proxy) throws Throwable {
        // TODO Auto-generated method stub
        System.out.println("日志记录：在目标方法执行之前");
        //代理类调用父类的方法
        proxy.invokeSuper(obj, args);
        System.out.println("日志记录：在目标方法执行之后");
        return null;
    }
}
