package ch2;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/14 下午5:30
 */
public class SimpleWNA {
    final static Object object = new Object();
    public static class T1 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis()+"T1 start!");

                try {
                    System.out.println(System.currentTimeMillis()+"T1 wait for object ");
                    object.wait();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(System.currentTimeMillis()+"T1 end!");
            }
        }
    }

    public static class T2 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis()+"T2 static! notify one thread");
                object.notifyAll();
                System.out.println(System.currentTimeMillis()+"T2 end");
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1_0 = new T1();
        Thread t1_1 = new T1();

        Thread t2 = new T2();

        t1_0.start();t1_1.start();t2.start();
    }


}
