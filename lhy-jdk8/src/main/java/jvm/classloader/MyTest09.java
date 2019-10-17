package jvm.classloader;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-10-17 09:32
 */
class Parent{
    static int a = 3;
    static {
        System.out.println("Parent static block");
    }
}

class Child extends Parent{

    static int s = 4;

    static {
        System.out.println("Child staitc block");
    }
}
public class MyTest09 {


    static {
        System.out.println("MyTest09 static block");
    }


    public static void main(String[] args) {
        System.out.println(Child.s);
    }

}
