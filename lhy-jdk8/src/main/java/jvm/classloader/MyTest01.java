package jvm.classloader;

/**
 *
 * 对于静态字段来说，只有直接定义了该字段的类才会初始化；
 * 当一个类在初始化时，要求其父类全部都初始化完毕了；
 * -XX:+TraceClassLoading,用于追踪类的加载信息并打印出来
 *
 * -XX:+<option> 表示开启 option 选项
 * -XX:-<option> 表示关闭 option 选项
 * -XX:<option>=<value> 表示 option 选项的值设置为 value
 *
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-09-20 16:41
 */
public class MyTest01 {
    public static void main(String[] args) {
        System.out.println(MyChild1.str2);
    }
}

class MyParent1{
    public static String str = "hello world";

    static {
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1{

    public static String str2 = "MyChild1 Hello";
    static {
        System.out.println("MyChild1 static block");
    }
}
