package org.lhy.design.decorator.test;

/**
 * 装饰器的抽象类，通过继承目标接口，实现接口实例对象，来完成装饰的预封装
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/4 下午12:05
 */
public abstract class Decorator extends Component{
    protected Component component;
    public void setComponent(Component component) {
        this.component = component;
    }
    /**
     * 重写operation，实际上执行的是Component类的operation()方法
     */
    @Override
    public void operation() {
        if(component!=null) {
            component.operation();
        }
    }
}