package org.lhy.design.decorator.test;

/**
 * 具体实例，需要对此实例进行装饰
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/8/4 下午12:04
 */
public class ConcreteComponent extends Component{
    @Override
    void operation() {
        System.out.println("具体对象的操作");
    }
}
