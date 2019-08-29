package thread01;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-04-18 15:07
 */
public class ThreadTest {

    private static void attack(){
        System.out.println("fight");
        System.out.println("current thread is : "+Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                attack();
            }
        };

        System.out.println("current main thread is : "+Thread.currentThread().getName());
//        thread.run();
        thread.start();
    }
}
