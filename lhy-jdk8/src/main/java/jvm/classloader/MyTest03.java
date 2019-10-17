package jvm.classloader;

import java.util.UUID;

/**
 * 当一个常量的值并非编译期间可以确定的，那么就不会放置在调用类的常量池中
 * 这时在程序运行时，会导致主动使用这个常量所在的类，显然会导致这个类初始化
 *
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-09-26 23:07
 *
 *
 */
public class MyTest03 {

    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3{

    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3 static block");
    }

}