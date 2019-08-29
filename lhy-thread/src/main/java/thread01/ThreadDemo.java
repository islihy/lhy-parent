package thread01;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-04-18 15:27
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("Thread1");
        MyThread myThread2 = new MyThread("Thread2");
        MyThread myThread3 = new MyThread("Thread3");
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
