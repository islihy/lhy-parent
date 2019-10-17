package jvm.classloader;

/**
 * -XX:+TraceClassLoading,用于追踪类的加载信息并打印出来
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-10-17 09:39
 */


class Parent2{
    static int a =2 ;
    static {
        System.out.println("Parent2 static block");
    }
}

class Child2 extends Parent2{
    static int b = 3;
    static {
        System.out.println("Child2 static block");
    }

}

public class MyTest10 {

    static {
        System.out.println("MyTest10 static block");
    }

    public static void main(String[] args) {

        Parent2 parent2 ;

        System.out.println("---------");

        parent2 = new Parent2();

        System.out.println("=========");

        System.out.println(Parent2.a);

        System.out.println(Child2.b);
    }
}
