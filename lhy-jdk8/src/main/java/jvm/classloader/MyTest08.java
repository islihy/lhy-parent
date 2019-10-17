package jvm.classloader;

import java.util.Random;

/**
 *
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-10-17 09:13
 */

class FinalTest{
    public static final int x = 3;

//    public static int x = 3;

//    public static final int x = new Random().nextInt(3);
    static {
        System.out.println("FinalTest static block");
    }
}
public class MyTest08 {

    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}
