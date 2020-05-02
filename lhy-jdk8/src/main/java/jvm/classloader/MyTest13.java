package jvm.classloader;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-10-17 19:54
 */
public class MyTest13 {

    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);

        while (classLoader!=null){
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }


    }
}
