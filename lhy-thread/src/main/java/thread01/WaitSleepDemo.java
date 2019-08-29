package thread01;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2019-04-18 17:16
 */
public class WaitSleepDemo {
    public static void main(String[] args) {
        final Object lock = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread A is waiting to get lock");

                synchronized (lock){
                    System.out.println("Thread A is get lock");
                    try {
                        Thread.sleep(20);

                    System.out.println("Thread A is do wait method");
                    lock.wait(1000);

                    System.out.println("Thread A is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        try {
            Thread.sleep(10);
        }catch (InterruptedException e){}


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread B is waiting to get lock");

                synchronized (lock){
                    System.out.println("Thread B is get lock");
                    try {
                        System.out.println("Thread B is sleep");
                        Thread.sleep(20);
                        System.out.println("Thread B is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
