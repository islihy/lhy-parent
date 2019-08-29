package thread01;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-04-18 15:32
 */
public class RunnableDemo {
    public static void main(String[] args) {
        MyRunnable mra1 = new MyRunnable("runnable1");
        MyRunnable mra2 = new MyRunnable("runnable2");
        MyRunnable mra3 = new MyRunnable("runnable3");

        new Thread(mra1).start();
        new Thread(mra2).start();
        new Thread(mra3).start();
    }
}
