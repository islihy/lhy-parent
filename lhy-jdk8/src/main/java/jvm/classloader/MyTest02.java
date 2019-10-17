package jvm.classloader;

/**
 *
 * 在编译阶段：常量会被存入到调用这个常量的方法的类的常量池中
 * 本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量的类的初始化
 * ps：常量str存放到了Mytest02的常量池中，之后MyTest02和MyParent2就没有任何关系了。即使删除了MyParent2也没有关系了
 *
 *
 *
 * javap -c MyTest02
 *
 *
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-09-26 22:22
 */
public class MyTest02 {

    public static void main(String[] args) {
        System.out.println(MyParent2.i_2);
    }
}

class MyParent2{

//    public static String str ="hello world!";
    public static final String str ="hello world!";

    public static final short s = 127;

    public static final int i = 129;

    public static final int i_1 = 1;

    public static final int i_2 = 6;


    static{
        System.out.println("MyParent2 static block");
    }
}
