package jvm.classloader;

import java.util.Random;

/**
 *
 * 当一个在初始化时，并不要求其父接口都完成了初始化，
 * 只有在真正使用父接口时（如在方法中使用到了父接口的常量），才会对父接口进行初始化
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-09-27 20:52
 */
public class MyTest05 {

    public static void main(String[] args) {
//        System.out.println(MyChild5.b);

        new c();
        System.out.println("======");
        new c();
    }
}

interface MyParent5{
    public static final int a = 5;
}

interface MyChild5 extends MyParent5{
//    int b = 6;
    int b = new Random().nextInt(2);
}

class c{



    static {
        //静态代码块 是在类 初始化的时候进行执行
        System.out.println("hello i c static");
    }

    //构造方法在类实例的时候执行，且在代码块之后执行
    public c(){
        System.out.println("c construct");
    }

    {
        //实例 创建几次 代码块执行几次
        System.out.println("hello i`m c");
    }
}
