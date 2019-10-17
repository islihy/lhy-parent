package jvm.classloader;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-10-17 09:54
 */

class Parent3{
    static int a =3;
    static {
        System.out.println("Parent3 static block");
    }

    static void doSometing(){

        System.out.println("do some ting");
    }
}

class Child3 extends Parent3{
    static {
        System.out.println("Child3 static block");
    }
}

public class MyTest11 {

    public static void main(String[] args) {
        System.out.println(Child3.a);
        Child3.doSometing();
    }
}
