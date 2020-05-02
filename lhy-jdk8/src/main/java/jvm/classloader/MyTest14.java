package jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 *
 * 1. 获取当前类的          clazz.getClassLoader();
 * 2. 获取当期线程上下文的   Thread.currentThread().getContextClassLoader();
 * 3. 获取系统的           ClassLoader.getSystemClassLoader();
 * 4. 获取调用者的  KDebug.getCallerClassName();
 * public class KDebug {
 *     public static String getCallerClassName() {
 *         StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
 *         for (int i=1; i<stElements.length; i++) {
 *             StackTraceElement ste = stElements[i];
 *             if (!ste.getClassName().equals(KDebug.class.getName()) && ste.getClassName().indexOf("java.lang.Thread")!=0) {
 *                 return ste.getClassName();
 *             }
 *         }
 *         return null;
 *      }
 * }
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-10-17 20:09
 */
public class MyTest14 {

    public static void main(String[] args) throws IOException {
        /**
         * Returns the context ClassLoader for this Thread. The context
         * ClassLoader is provided by the creator of the thread for use
         * by code running in this thread when loading classes and resources.
         * If not {@linkplain #setContextClassLoader set}, the default is the
         * ClassLoader context of the parent Thread. The context ClassLoader of the
         * primordial thread is typically set to the class loader used to load the
         * application.
         *
         *
         */
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String str = "jvm/classloader/MyTest13.class";

        Enumeration<URL> urls = classLoader.getResources(str);

        while (urls.hasMoreElements()){
            URL url = urls.nextElement();
            System.out.println(url);
        }


        Class c = MyTest14.class;
        System.out.println(c.getClassLoader());

        System.out.println(String.class.getClassLoader());

    }
}
