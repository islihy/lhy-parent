package jvm.classloader;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-10-17 10:03
 */

class CL{
    static {
        System.out.println("CL static block");
    }
}

/**
 * 调用 ClassLoader 的 classLoader 方法加载一个类，并不是对一个类的主动使用
 * 反射 forName 方法，才是对类的主动使用
 */
public class MyTest12 {

    public static void main(String[] args) throws ClassNotFoundException{
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Class<?> c = cl.loadClass("jvm.classloader.CL");
        System.out.println(c);
        System.out.println("==================");
        c = Class.forName("jvm.classloader.CL");

        System.out.println(c);
    }
}
