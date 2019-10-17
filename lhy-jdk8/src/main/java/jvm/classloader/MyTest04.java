package jvm.classloader;

/**
 *
 * 助记符：
 *  anewarray: 表示创建一个引用类型的数组（如 类，接口，数组），并将其引用类型压入栈顶
 *  newarray: 表示创建一个指定的原始类型（如 int float chat 等）的数组，并将其引用值压入栈顶
 *
 *
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-09-26 23:16
 */
public class MyTest04 {

    public static void main(String[] args) {

        //类的主动使用，导致类是进行初始化--静态代码块的执行
        //ps：类的初始化只会进行一次，即这个地方在第一次的时候只会初始化一次
//        MyParent4 myParent5 = new MyParent4();
//        MyParent4 myParent4 = new MyParent4();


        //不会导致对类的初始化

        MyParent4[] myParent4s= new MyParent4[1];
        //class [Ljvm.classloader.MyParent4;  这个类型是jvm在运行期生成出来的
        //对于数组实例，其类型是jvm在运行期动态生成--表示为[L ...  、 动态生成的类型 其父类型就是Object
        //对于数组来说，JavaDoc 常将构成数组的元素称之为 component, 实际就是将数组降低一个维度后的类型
        System.out.println(myParent4s.getClass());
        System.out.println(myParent4s.getClass().getSuperclass());

        MyParent4[][] myParent4s1 = new MyParent4[1][1];
        System.out.println(myParent4s1.getClass());


        int[] ints =new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

        char[] chars = new char[1];
        System.out.println(chars.getClass());

        boolean[] booleans = new boolean[1];
        System.out.println(booleans.getClass());

        short[] shorts  = new short[1];
        System.out.println(shorts.getClass());

    }
}

class MyParent4{
    static {
        System.out.println("MyParent4 static block");
    }
}
