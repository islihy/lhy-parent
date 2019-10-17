package jvm.classloader;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-10-13 16:48
 */
public class MyTest07 {

    public static void main(String[] args) throws ClassNotFoundException{
        Class<?> aClass = Class.forName("java.lang.String");

        ClassLoader classLoader = aClass.getClassLoader();
        System.out.println(classLoader);

        /**
         * sun.misc.Launcher$AppClassLoader@135fbaa4
         * sun.misc.Launcher 下内部类 AppClassLoader
         * @135fbaa4 就是 哈希code
         */
        aClass = Class.forName("jvm.classloader.a");
        System.out.println(aClass.getClassLoader());
    }
}

class a{

}
